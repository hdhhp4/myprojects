import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import store from './store'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import './assets/css/style.css'

Vue.use(ElementUI)
Vue.use(mavonEditor)

Vue.config.productionTip = false

new Vue({
    store,
    router,
    render: h => h(App)
}).$mount('#app')
