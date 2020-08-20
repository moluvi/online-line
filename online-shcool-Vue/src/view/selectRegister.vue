<template>
  

  

    <!-- <div class="logninfo">
        <a href="/" style="border: none;"><img src="/Public/Home/img/logo3.png" alt="" srcset=""></a>
        <p>中国领先的互动课堂管理平台</p>
        <a href="/User/login.html">已有账号，去登录</a>
    </div> -->

    <div class="big" :style="backgroundDiv">
    <div class="logincon">
    
        
        <div class="identity-box">
            <h3>注册账号</h3>
            <p style=" margin-top: 20px; color: #707070;">请选择您在日常教学中的实际身份</p>
            
           
            <div class="choose" style="float:left">
            
                <a href="#/RegisterTeacher" class="teacher">我是老师/助教</a>
                <a href="#/RegisterStudent" class="student">我是学生</a>
            </div>
            <a href="#/login_page" class="btn-login">
                <span class="str1" style="color:#8D99A5;font-size:13px">已有账号？</span>
                <span class="str2" style="color:#66A7E9;font-size:13px">去登录
            </span></a>
        </div>
    </div>
</div>
</template>
<script>
import qs from 'qs'
export default {
    data() {
    return {
   
      user: {},
      username: '',
      password: '',
      msg: '',
      backgroundDiv: {
          backgroundImage: "url(" + require("../assets/regbg.jpg") + ")",
          backgroundRepeat: "no-repeat",
          backgroundSize:'100% 100%'
         
      },   
    }
  },    
  methods: {
    submit() {
      this.login();
    },
   
     jumpToList() {
      this.$router.push('/homePage')
    }
  },

}
</script>
<style scoped>
.big{
  
  height:100%;
  width:100%;  
}
.logincon {
    margin-top: 50px;
    width: 480px;
    height: 504px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%,-65%);
}

.identity-box {
    width: 480px;
    height: 400px;
    padding: 47px 41px 0;
    background: 
    #FFF;
    margin-left: auto;
    margin-right: auto;
    box-sizing: border-box;
    border-radius: 4px;
}

.identity-box .choose {
    margin-top: 70px;
    margin-left: -25px;
}

.identity-box .choose a {
    display: block;
    width: 330px;
    font-size: 16px;
    color: 
#fff;
height: 64px;
line-height: 64px;
text-align: center;
background:
    #32BAF0;
    border-radius: 4px;
    margin-left: 70px;
    position: relative;
}

.student {
  margin-top:20px;
}

a {
    text-decoration: none;
    outline: 0;
    blr: expression(this.onFocus=this.blur());
}


.identity-box .btn-login, .login-box .btn-register {
    float: right;
    margin-top: 24px;
}
</style>