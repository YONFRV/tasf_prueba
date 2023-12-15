import axios from 'axios';
import { defineStore } from 'pinia';
import { show_alerta } from '../functions';


export const useAuthStore = defineStore('auth',{
    state: () => ({authUser:null, authToken:null}),
    getters:{
        user:(state) =>  state.authUser,
        token: (state) =>  state.authToken
    },
    actions:{
        async login(form) {
            await axios.post('/api/v1/login', form).then(
                (res) => {
                    const jsonObject = JSON.parse(res.data.data);
                    this.authToken = jsonObject.apikey;
                    this.authTUser = jsonObject.userName;
                    this.router.push('/sale');
                })
                .catch((errors) => {
                    show_alerta(res.data.menssage, 'errors', '');
                });
        },
        async sale(form) {
            await axios.post('/api/v1/sale/', form).then(
                (res) => {
                    this.authToken = res.data.token;
                    this.authTUser = res.data.data;
                    this.router.push('/sale');
                })
                .catch((errors) => {
                    console.log(errors.response.data);
                    let desc = '';
                    errors.response.data.errors.map((e) => {
                        desc = desc + ' ' + e;
                    });
                    show_alerta(desc, 'errors', '');
                });
        },

    }
})