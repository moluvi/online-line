<template>
  <!--<el-form ref="user" :model="user" label-width="80px" style="width:300px;margin-left:40%">
    <el-form-item label="用户名">
      <el-input v-model="user.username" style="width:240px;" ></el-input>
    </el-form-item>
    <el-form-item label="密码">
      <el-input type="password" v-model="user.password" style="width:240px;" ></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="submit">提交</el-button>
    </el-form-item>
  </el-form> -->
  
  <div class="big" :style="backgroundDiv">
    
    
    <div class="login_warp">
     
        <!-- 三个选项卡按钮 -->
        <div class="login_header">
          <span @click="cur=0" :class="{active:cur==0}">账号登录</span>
          <span @click="cur=1" :class="{active:cur==1}" style="margin-right: 100px">微信登录</span>
        </div>
      
      
      <div class="login_content">
      
        <!-- 在cur==0时此板块显示 其他时候此板块不显示 -->
        <div v-show="cur==0" class="Cbody_item">
          
           <el-form ref="user" :model="user" label-position="right" label-width="auto" show-message>
           
            <el-form-item prop="loginName" style="margin-left: 25px;">
                <el-col :span="22">
                    <el-input type="text" v-model="user.username" placeholder="账号/手机号/邮箱"></el-input>
                </el-col>
            </el-form-item>
            <el-form-item prop="loginPassword" style="margin-left: 25px;">
                <el-col :span="22">
                    <el-input type="password" v-model="user.password" placeholder="密码"></el-input>
                </el-col>
            </el-form-item>
            <el-form-item>
                <el-col :span="22">
                  <div class="fl"><input type="checkbox">下次自动登录</div>
                  <div class="fr"><a href="javascript:;" >忘记密码？</a></div> 
                </el-col>               
            </el-form-item>
            <el-form-item>
                <el-button type="primary" style="width: 350px;" @click="submit">登录</el-button>
            </el-form-item>

            <el-form-item>
                <div class="fr" style="margin-right:25px">还没有账号？<a href="#/selectRegister" style="color:#3C84CC" >去注册</a></div> 
            </el-form-item>
        </el-form>


        </div>

        <!-- 在cur==1时此板块显示 其他时候此板块不显示 -->
        <div v-show="cur==1" class="Cbody_item" >
          <div class="qcode"><img src="../assets/qnode.jpg" width="160" height="160" alt="二维码" /></div>
          <div class="beizhu">打开手机客户端扫码注册</div>
        </div>
     </div>
  
  
  
     
  
 
 </div>
 </div>
 


</template>
<script>
import {postRequest} from '../utils/api'
import qs from 'qs'
export default {
    data() {
    return {
      type: '',
      user: {},
      username: '',
      password: '',
      cur:0, //默认选中第一个tab
      backgroundDiv: {
          backgroundImage: "url(" + require("../assets/bg.jpg") + ")",
          backgroundRepeat: "no-repeat",
          backgroundSize:'100% 100%',
   
         
      },   
    }
  },    
  methods: {
    submit() {
      
       this.login();
      
    },
    login() {
      postRequest("/login", {
        username: this.user.username,
        password: this.user.password
      })

      .then(res => {
        
     
        let isTeacher = false
        if (res.data.status === 200) {
          this.$message({
            message: '登录成功',
            type: 'success'
          });
         
          for (let i = 0; i < res.data.msg.roles.length; i++) {
            if (res.data.msg.roles[i].nameZh === '老师') {
              isTeacher = true
            }      
          }
          
          if (isTeacher) {
            this.$router.push('/teacherPage/' + res.data.msg.username)
             localStorage.setItem('token',res.data.token)
                // 将登录名使用vuex传递到Home页面
            this.$store.commit('handleUserName',res.data.username);
          } else {
            this.$router.push('/studentPage/' + res.data.msg.username)
          }
        } else {
          this.$message.error(res.data.msg)
        }
      })
      .catch(err => {
        alert(err.response.data.msg);
        console.log(err);
      });
    },


     jumpToList() {
      this.$router.push('/teacherPage')
    }
  },

}
</script>
<style scoped>

.big{
  
  height:100%;
  width:100%;  
}


.fl{
 float: left;
 margin-left: 25px;
 font-size: 11px;
 color: #848E99;
}
.fr{
   font-size: 11px;
 color: #A5AEB8;
 float: right;
}



a{
 text-decoration: none;
 color: #A5AEB8;
 transition: ease all 0.5s;
}

.login_header{
  margin-top: 30px;
 margin-bottom: 5px;
 height:50px;
}
.login_header span{
 margin-right: 90px;
 cursor: pointer;
}


.el-form-item {
    margin-bottom: 18px;
    height: 40px;
    font-size: 40px;
}

.Cbody_item{
 border: 0px solid #999;
 overflow: hidden;
}

.login_warp{
 width: 400px;
 height: 390px;
 margin: auto;
 border-radius: 5px;
 box-shadow: 0 0px 0px #ccc;
 overflow: hidden;
 border:1px solid #576778;
 background-color: #FFFFFF; 
 transition: ease all 0.5s;
 position: relative;
 top: 130px;
 cursor: pointer;
}

.login_content {
  margin-top: 30px;
}

.qcode{
 width: 160px;
 height: 160px;
 background-color: #ccc;
 margin: 0 auto;
 margin-top: 2px;
}
.active{
 
 padding-bottom: 10px;
 font-size: 23px;
 border-bottom: 3px solid #747C85;
}


</style>