<template>
    <div id="index" class="container">
        <el-row>
            <el-col :span="24">
                <el-row>
                    <el-col :span="24">
                        <div class="info">
                            <div class="content">
                                <p><span><strong>Hello！我是何东红</strong></span></p>
                                <p class="title-second"><span>Java/JavaScript/CSS/HTML/Python</span></p>
                                <ul class="user-info">
                                    <li class="user-info-item">
                                        <label>联系电话</label>
                                        <span>15755378449</span>
                                    </li>
                                    <li>
                                        <label>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址</label>
                                        <span>浙江省杭州市滨江区</span>
                                    </li>
                                    <li>
                                        <label>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</label>
                                        <span>hedonliberty@163.com</span>
                                    </li>
                                    <li>
                                        <label>网&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;站</label>
                                        <span><a href="https://www.donhhe.com"
                                                 target="_blank">https://www.donhhe.com</a></span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </el-col>
                </el-row>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    export default {
        name: "Index"
    }
</script>

<style scoped>
    .info {
        display: inline-block;
        width: 73rem;
        padding: 10px;
        height: 40rem;
        background-image: url(../assets/img/genie.jpg);
        background-repeat: no-repeat;
        -webkit-box-shadow: 0 15px 30px rgb(21, 16, 16);
        box-shadow: 0 15px 30px rgb(21, 16, 16);
    }

    .info .content {
        border: 1px solid #fff;
        padding-top: 30px;
        padding-left: 15px;
        text-align: left;
        width: 20rem;
        float: right;
        background-color: #03A9F4;
        line-height: 2rem;
        border-radius: 6px;
    }

    ul.user-info {
        color: #fff;
        list-style: none;
        padding: 10px;
    }

    ul.user-info label {
        font-weight: bold;
        display: inline-block;
        text-align: right;
        margin-right: 20px;
    }

    .title-second {
        font-size: 12px;
        padding-bottom: 10px;
        border-bottom: 1px solid #fff;
    }
</style>