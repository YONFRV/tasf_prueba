import Swal from 'sweetalert2';
import { nextTick } from '@vue/runtime-core';
import { useAuthStore } from '@/stores/auth'
import axios from 'axios';


export function show_alerta(msj,icon,focus){
    if(focus !== ''){
        nextTick( () => focus.value.focus());
    }
    Swal.fire({
        title:msj,icon:icon,buttonsStyling:true
    });
}


export async function sendRequest(method,params,url,redirect=''){
    const authStore = useAuthStore();
    axios.defaults.headers.common['Authorization'] = 'Bearer '+authStore.authToken;
    let res;
    await axios({ method:method, url:url, data:params}).then(
        response =>{
            res= response.data.status,
            show_alerta(response.data.message,'success',''),
            setTimeout( 
                ()=> (redirect !=='') ? window.location.href = redirect:''
                ,2000)
        }).catch((errors) =>{
            let desc='';
            res = errors.response.data.status;
            errors.response.data.errors.map( (e) =>{ desc= desc+' '+e})
            show_alerta(desc,'error','')
        })
       return res;
} 