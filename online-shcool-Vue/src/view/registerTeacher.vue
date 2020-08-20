<template>
 <div class="big" :style="backgroundDiv">

    <div class="logincon">

       <div class="header">
          <span style="float:left"><img src="../assets/backIcon.png"></span>
          <span style="margin-left:10px; float:left; font-size: 30px; ">老师/助教注册</span>
        </div>
           
            <div>
              <el-form ref="teacherForm" :model="teacherForm" label-width="60px" style="width:320px;margin-left:3%">
              <el-form-item label="用户名">
                 <el-input v-model="teacherForm.name" style="width:260px;" ></el-input>
              </el-form-item>
              
              <el-form-item label="密码">
                 <el-input v-model="teacherForm.password"  type="password" style="width:260px;" ></el-input>
              </el-form-item>

              <el-form-item label="学校">
                 <el-select v-model="teacherForm.school" placeholder="请选择学校" style="width:260px;">
                    <el-option label="重庆大学" value="重庆大学"></el-option>
                    <el-option label="重庆理工大学" value="重庆理工大学"></el-option>
                 </el-select>
                
              </el-form-item>
              


    
              <el-form-item >
                  <el-button style="background-color:#09C1F5;width:260px;color:#fff;" @click="submit">
                    注册成为老师/助教</el-button>
                 
             </el-form-item>

              <el-form-item style="padding-left:30px">

                <a href="#/login_page" class="btn-login" style="margin-left:115px">
                <span class="str1" style="color:#8D99A5;font-size:11px">已有账号？</span>
                <span class="str2" style="color:#66A7E9;font-size:11px">去登录
                </span></a>

              </el-form-item>
            </el-form>        

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
      
      teacherForm: {},
     
      msg: '',
      backgroundDiv: {
          backgroundImage: "url(" + require("../assets/regbg.jpg") + ")",
          backgroundRepeat: "no-repeat",
          backgroundSize:'100% 100%',
         
         
      },   
    }
  },    
  methods: {
    submit() {
       this.addStudent();
    },
 
     addStudent() {
     postRequest('/reg/registerTeacher', {
          username: this.teacherForm.name,
          nickname: '教师',
          password: this.teacherForm.password,  
          school: this.teacherForm.school
        },{
          headers: {
        'Content-Type':'application/x-www-form-urlencoded',
         }
        })
        .then(res => {
          alert("已注册成功,返回登录");
          this.teacherForm = {}
          this.jumpToList()
      })
      .catch(err => {
         alert("注册失败！");
          console.log(err);
      });
      
    },
    
     jumpToList() {
      this.$router.push('/login_page')
    }
  },

}
</script>
<style scoped>

a {
    text-decoration: none;
    outline: 0;
    blr: expression(this.onFocus=this.blur());
}

.big{
  
  height:100%;
  width:100%;  
}

.header{
    padding-top: 20px;
    padding-left: 35px;
    background-color: #FFFFFF; 
    height: 60px;
}
.logincon {
   width: 380px;
   height: 390px;
   margin: auto;
   border-radius: 10px;
   box-shadow: 0 0px 0px #ccc;
   overflow: hidden;
   border:1px solid #3f7dff;
   background-color: #FFFFFF; 
   transition: ease all 0.5s;
   position: relative;
   top: 120px;
   cursor: pointer;
   
}


</style>