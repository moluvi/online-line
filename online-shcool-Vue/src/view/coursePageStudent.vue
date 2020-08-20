<template>
  
  <el-container>

    <el-header>

    
        <el-drawer
          title="我是标题"
            :visible.sync="drawer"
            :direction="direction"
            :before-close="handleClose">
           <span>欢迎使用课堂派!</span>
        </el-drawer>

        <el-menu class="el-menu-demo" mode="horizontal" @select="">
            <el-menu-item>   
             
                <i class ="el-icon-s-fold"  @click="drawer = true" style="margin-left: 16px;width:20px;height:20px;"></i>
            </el-menu-item>
            <el-menu-item>
              <el-breadcrumb separator-class="el-icon-arrow-right" style="font-size: 12px;line-height:5;">
                <el-breadcrumb-item :to="{ path: '/' }">课堂</el-breadcrumb-item>
                <el-breadcrumb-item>{{courseName}}</el-breadcrumb-item>
              </el-breadcrumb>
            </el-menu-item>
            
               
        </el-menu>

    </el-header>
    
    
    
    <el-main>

      <div class="box">
        

        <div class="topbox">
          <el-row>
            <el-col :span="24"><div class="grid-content bg-purple-dark"></div></el-col>
          </el-row>
          <el-row style="height: 55px">
            <el-col :span="4">
              <div class="grid-content bg-purple" style="font-size:36px; color:white">
                {{courseForm.courseName}}<i class="el-icon-edit-outline"></i></div>
            </el-col>
            <el-col :span="12"><div class="grid-content bg-purple-light"></div></el-col>
          </el-row>
          <el-row >
            <el-col :span="4">
              <div class="grid-content bg-purple" style="font-size:25px;color:white">{{courseForm.courseClass}}</div>
            </el-col>
            <el-col :span="8"><div class="grid-content bg-purple-light"></div></el-col>
            <el-col :span="8"><div class="grid-content bg-purple"></div></el-col>
          </el-row>
           <el-row :gutter="4" style="padding-top: 20px;">
           <el-col :span="2.5"><div class="grid-content bg-purpleC" style="margin-left:20px">加课码:{{courseForm.courseNO}}</div></el-col>
  
            <el-col :span="1.3"><div class="grid-content bg-purpleC">成员:{{courseForm.member}}</div></el-col>
            
            <el-col :span="2.2"><div class="grid-content bg-purpleC">数据分析</div></el-col>
          </el-row>
        </div>

        <div class="coursebanner"  style="font-size:20px;">
          <el-menu class="el-menu-demo" mode="horizontal" style="background-color:#E9EEF3;">
            <el-menu-item class="snav" index="1">作业</el-menu-item>
            <el-menu-item class="snav" index="2">课堂互动</el-menu-item>
            <el-menu-item class="snav" index="3">资料</el-menu-item>
          </el-menu>
        </div>


        <div class="workpage" v-for="(item,index) in allWork">
          <div style="height:50px">
              <div style="font-size:13px;margin-left:50px;margin-top:15px;background-color:#E9EEF3; line-height: 36px;width:7%;float:left">
                个人作业
              </div>

               <div style="font-size:12px;margin-top:15px;line-height: 36px;width:20%;float:left">
                {{item.publishTime}}
              </div>
              <div style="float:left;margin-left:550px;margin-top:15px;width:5%;background-color:#E9EEF3;">
                
              </div>


          </div>  
           
         
          
          <div style="height: 80px">
            <div style="height: 70px;"> 
                 <span style="padding-right: 720px;"><a  style="cursor: pointer" >{{item.workName}}</a></span>
                 <br>
                 <p style="padding-right: 630px;">
                    {{item.workDetail}}
                 </p>
            </div>
            
            
          </div>
          
          <div style="width:50px;height:60px; margin-left:50px">
              
              <img src="../assets/doc.png"  style="width:50px;height:40px;">
              <a   @click="workDownload(item.workFile)" style="cursor:pointer"><span style="font-size:15px;color:#94A0AD">下载</span>
              </a>

          </div>


          <div style="margin-top:10px;">
              
              <div  style="float:left;margin-left:50px ">

                <span style="font-size: 14px; color:#C2C9D0 ">  截止日期 {{item.workDate}}</span>

              </div>

              <div style="float:left;margin-left:550px">
                   <el-upload
                  class="avatar-uploader"
                   action="http://127.0.0.1:8080/file/upload"
                  :on-success="handleAvatarSuccess"
                   :show-file-list="true">
                  <el-button  size="small" type="primary" @click="getId(item.workId)">{{upText}}</el-button>
                </el-upload>
            </div>
          </div>
        </div>


        
        <div class="bottom">

        </div>


    </div>
       
        

        
        <!-- <div class="workpage" v-for="(item,index) in allWork">
          <el-row>
            <el-col :span="3"><div class="grid-content bg-purple-dark">个人作业</div></el-col>
            <el-col :span="2"><div class="grid-content bg-purple-dark">{{item.workDate}}</div></el-col>
            <el-col :span="18"><div class="grid-content bg-purple-dark"></div></el-col>
            <el-col :span="1">
            
            </el-col>
          </el-row>
          
          <el-row >
            <el-col :span="4">
              <div class="grid-content bg-purple" style="color:white">
                 <a @click="jumpToDetail(item.workId)" style="cursor: pointer" >{{item.workName}}</a></div>
            </el-col>
            
          </el-row>
          
          <el-row  style="">
            <el-col :span="5"><div class="grid-content bg-purple">{{item.workDetail}}</div></el-col>
            <el-col :span="16"><div class="grid-content bg-purple"></div></el-col>
            <el-col :span="3">
                <el-upload
                   class="avatar-uploader"
                   action="http://127.0.0.1:8080/file/upload"
                  :show-file-list= "true"
                  :on-success="handleAvatarSuccess">
                
                  <el-button  size="small" type="primary" @click="getId(item.workId)">上传作业</el-button>
                </el-upload>
            </el-col>
          </el-row>

          <el-row  style="">
            <el-col :span="5"><div class="grid-content bg-purple">截止日期</div></el-col>
           
            <el-col :span="5"><div class="grid-content bg-purple">{{item.workDate}}</div></el-col>
            <el-col :span="2"><div class="grid-content bg-purple"></div></el-col>
          </el-row>
        </div>  -->

        

        
      </div>

     
    

    </el-main>
  </el-container>



</template>
<script>
import {postRequest} from '../utils/api'
export default {
      data() {
      return {
        drawer: false,
        direction: 'ltr',
        username: this.$route.params.username,
        courseName: this.$route.params.courseName,
        courseForm: {},
        allWork: {},
        workId: '',
        fileUrl:'',
        replyFile:'',
        nowTime: '', // 获取当前时间
        upText: '上传作业'
       
      };
    },
    methods: {
      handleClose(done) {
       done();
      },

     

      jumpIndex() {
       
         this.getAllWorks();
      },
      
      getId(workId) {
        this.workId = workId;
      },
      
      getCourseByName() {
        postRequest("/course/getCourseByName", {courseName: this.courseName})      
        .then(res => {
          console.log(res);
          this.courseForm = res.data;
        })
        .catch(err => {
          alert(err.response.data.msg);
          console.log(err);
        });
      },

      getAllWorks() {
        
        postRequest("/work/getWorksByTeacher", {
          courseName: this.courseName
        }) 
        .then(res => {
          console.log(res);
          this.allWork = res.data
        })
        .catch(err => {
          alert(err.response.data.msg);
          console.log(err);
        });
      },

      getWorkById(workId) {
           
        postRequest("/work/getWorkById", {
          workId: workId
        }) 
        .then(res => {
          console.log(res);
          this.workEditForm = res.data
        })
        .catch(err => {
          alert(err.response.data.msg);
          console.log(err);
        });
      },


      jumpToDetail(workId) {
        this.$router.push('/correctPage/' + workId)
      },

      handleAvatarSuccess(res, file) {
        this.fileUrl = URL.createObjectURL(file.raw);
        this.replyFile=res;
        this.nowTimes();
        postRequest("/reply/upReply", {
          workId: this.workId,
          submitTime: this.nowTime,
          studentName: this.username,
          replyFile: this.replyFile
        }) 
        .then(res => {
          console.log(res);
          this.$message({
            message: '上传作业成功',
            type: 'success'
          });
         
          jumpIndex();
        })
        .catch(err => {
          alert(err.response.data.msg);
          console.log(err);
        });
      },

      timeFormate(timeStamp) {
          let year = new Date(timeStamp).getFullYear();
          let month =new Date(timeStamp).getMonth() + 1 < 10? "0" + (new Date(timeStamp).getMonth() + 1): new Date(timeStamp).getMonth() + 1;
          let date =new Date(timeStamp).getDate() < 10? "0" + new Date(timeStamp).getDate(): new Date(timeStamp).getDate();
          let hh =new Date(timeStamp).getHours() < 10? "0" + new Date(timeStamp).getHours(): new Date(timeStamp).getHours();
          let mm =new Date(timeStamp).getMinutes() < 10? "0" + new Date(timeStamp).getMinutes(): new Date(timeStamp).getMinutes();
          let ss =new Date(timeStamp).getSeconds() < 10? "0" + new Date(timeStamp).getSeconds(): new Date(timeStamp).getSeconds();
          this.nowTime = year + "-" + month + "-" + date +" "+hh+":"+mm+':'+ss ;
      },
      nowTimes(){
        this.timeFormate(new Date());
        setInterval(this.nowTimes,1000);
        this.clear()
      },
      clear(){
        clearInterval(this.nowTimes)
        this.nowTimes = null;
      },

      workDownload(workFile) {
         window.location.href= workFile;
      }




    },
    
    mounted() {
      this.getCourseByName();
      this.getAllWorks();
      
    },
}
</script>
<style scoped>
 /* el-row 排布样式*/
  .el-row {

    &:last-child {
      margin-bottom: 0;
    }
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: ;
  }
  .bg-purple {
    
  }

  .bg-purpleC{
    font-size: 15px;
    color:#fff;
    text-align: "center";
    height: 24px;
    line-height: 32px;
    background-position: 100px 10px;
    background-size: 14px auto;
    cursor: pointer;
    user-select: none;
    background: rgba(255,255,255,.4);
    border-radius: 2px;
    
  }
  .bg-purple-light {
    
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }

  .el-header {
  
   
    text-align: center;
    line-height: 60px;
  }
  
  .el-main {
    height: 700px;
    
    color: #333;
    text-align: center;
      
  }
  
  
  .box {  
    margin:auto;
    margin-top: 40px;
    background-size: auto;
    width: 900px;
    background-size: cover;
   
    border-radius: 8px 8px 0  0;
    box-sizing: border-box;
  }

  .topbox{
    
    height: 200px;
    border-radius: 8px 8px 0  0;
    background: url("//assets.ketangpai.com/theme/teacher/big/08.png");
    
  }

  .coursebanner {
    background-color: #E9EEF3;
    border-radius: 0 0 12px 12px;
    margin: 0 auto;

  }

  .snav {
    margin-left: 30px;
    padding-left: 15px;
    font-size: 14px;
  }
  

  .addWorkPage {
    height:400px;
    border-radius: 8px 8px 0  0;
    background-color: #FFFFFF;  
  }

  .editWorkPage {
    height:450px;
    border-radius: 8px 8px 0  0;
    background-color: #FFFFFF;  
  }

  .workbanner{
    width: auto;
    height: auto;
    background-color: #FFFFFF;  
  }
 

  .workpage{
    margin-top: 30px;
    height:250px;
    background-color: #FFFFFF;
    border-radius: 12px 12px 12px 12px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
  }


  .bottom {
    height: 220px;
    
  }


  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>