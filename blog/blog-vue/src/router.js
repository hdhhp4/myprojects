import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Index from './views/Index.vue'
import About from './views/About.vue'
import Work from './views/Work.vue'
import Blog from './views/Blog.vue'
import Contact from './views/Contact.vue'


Vue.use(Router)

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [{
        path: '/',
        name: 'home',
        component: Home,
        children: [{
            path: '/',
            name: 'index',
            component: Index
        }, {
            path: '/about',
            name: 'about',
            component: About
        }, {
            path: '/work',
            name: 'work',
            component: Work
        }, {
            path: '/blog',
            name: 'blog',
            component: Blog
        }, {
            path: '/contact',
            name: 'contact',
            component: Contact
        }]
    }]
})