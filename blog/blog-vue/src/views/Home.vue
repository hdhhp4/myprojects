<template>
    <div id="home">
        <el-row>
            <el-col :span="24">
                <ul class="menu">
                    <li class="menu-item logo-item">
                        <a href="javascript:;" class="menu-item-link">
                            <img src="../assets/img/logo.jpg" alt="" class="logo">
                        </a>
                    </li>
                    <li class="menu-item">
                        <router-link to="/" class="menu-item-link">首页</router-link>
                    </li>
                    <li class="menu-item">
                        <router-link to="/about" class="menu-item-link">关于我</router-link>
                    </li>
                    <li class="menu-item">
                        <router-link to="/work" class="menu-item-link">我的作品</router-link>
                    </li>
                    <li class="menu-item">
                        <router-link to="/blog" class="menu-item-link">博客</router-link>
                    </li>
                    <li class="menu-item">
                        <router-link to="/contact" class="menu-item-link">联系我</router-link>
                    </li>
                </ul>
            </el-col>
        </el-row>
        <el-row :gutter="20">
            <el-col :span="24"><router-view/></el-col>
        </el-row>
    </div>
</template>

<script>
    export default {
        name: 'home',
        components: {}
    }
</script>

<style scoped>
    .el-row{
        margin-bottom: 0px;
    }
</style>
