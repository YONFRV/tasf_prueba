<script setup>
    import { ref } from 'vue';  // Import the ref function from Vue
    import { useAuthStore } from '../stores/auth';
    const authStore = useAuthStore(); 
    const folioVenta = ref('');
    const ventas = ref([]);
    const totalProductos = ref(0);
    const totalVenta = ref(0);  
    const consultarVentas = async () => {
        axios.defaults.headers.common['apikey'] = authStore.authToken;
        await axios.get('/api/v1/sale/'+folioVenta.value).then(
                (res) => {
                    const resultSale = JSON.parse(res.data.data);
                    ventas.value = resultSale.listProduct;
                    totalProductos.value = resultSale.sale.totalProduct;
                    totalVenta.value = resultSale.sale.totalValue;
                })
                .catch((errors) => {
                    show_alerta(res.data.menssage, 'errors', '');
                });
};
</script>

<template>
    <div class="container">
        <div class="card">
            <div class="m-4">
                <h1>CONSULTA DE VENTAS</h1>
            </div>
            <div>
                <div class="m-2">
                    <span>Folio de Venta:</span>
                </div>
                <div class="m-4">
                    <form @submit.prevent="consultarVentas">
                        <div class="d-flex">
                            <div class="col-4">
                                <input v-model="folioVenta" type="number" class="form-control">
                            </div>
                            <div class=" col-3">
                                <div style="margin-left: 2em;">
                                    <button class="btn btn-dark">
                                        <i class="fa-solid fa-save"></i>Consultar
                                    </button>
                                </div>
                               
                            </div>
                        </div>
                    </form>
                </div>
                <div class="table-responsive m-2" >
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th scope="col">N°.</th>
                                <th scope="col">Producto</th>
                                <th scope="col">Cantidad</th>
                                <th scope="col">Precio Unitario</th>
                                <th scope="col">Total</th>
                            </tr>
                        </thead>
                        <tbody class="table-group-divider">
                        </tbody>
                        <tr  scope="row" v-for="(venta, index) in ventas" :key="index">
                            <td>{{venta.productId}}</td>
                            <td>{{venta.nameProduct}}</td>
                            <td>{{venta.amount}}</td>
                            <td>{{venta.priceProduct}}</td>
                            <td>{{venta.total}}</td>
                        </tr>
                      
                    </table>
                </div>
                <div class="row d-flex mt-4">
                    <div class=" col-6">
                        <h3>Total Productos: <span>{{totalProductos}}</span></h3>
                    </div>
                    <div class=" col-6">
                        <h3>Total Venta: <span>{{totalVenta}}</span></h3>
                    </div>
                </div>

            </div>
        </div>
    </div>
</template>
