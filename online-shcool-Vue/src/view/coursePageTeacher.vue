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
        <div class="workbanner" >
            <el-row>
              <el-col :span="6">
                <div class="grid-content bg-purple" style="background-color: #FFFFFF;padding-top:20px; padding-right:80px;">
                <el-button  style="border-color: #409EFF; color:#409EFF  " @click="toAddWork()">发布个人作业</el-button></div>
              </el-col>
            </el-row>
        </div>
        

        <div class="addWorkPage"  v-if="showDivAdd">

            <el-form ref="workAddForm" :model="workAddForm" label-width="80px">
                <el-form-item label="作业名称" style="padding-top:30px;">
                  <el-input v-model="workAddForm.workName" placeholder="输入作业名称"></el-input>
                </el-form-item>
                <el-form-item label="作业简介">
                  <el-input type="textarea" v-model="workAddForm.workDetail"></el-input>
                </el-form-item>
                <el-form-item label="截止日期">
                  <el-col :span="11">
                    <el-date-picker type="date" placeholder="选择日期" v-model="workAddForm.workDate" 
                      value-format="yyyy-MM-dd" style="width: 100%;"></el-date-picker>
                  </el-col>        
                </el-form-item>
                <el-form-item label="满分值" style="width:150px">
                  <el-input  v-model="workAddForm.fullGrade"></el-input>
                </el-form-item>
                <el-form-item style="margin-bottom:2px;margin-right:1100px;">
          
                <el-upload
                   class="avatar-uploader"
                   action="http://127.0.0.1:8080/file/upload2"
                  :show-file-list="false"
                  :on-success="handleAvatarSuccess">
                  <el-button size="small" type="primary">导入作业</el-button>
                </el-upload>
            </el-form-item>
            <el-form-item style="margin-left: 600px;">
              <el-button type="primary" @click="submitAdd">发布个人作业</el-button>
              <el-button @click="jumpIndex()">取消</el-button>
            </el-form-item>
            </el-form>
        </div>
      
        <div class="editWorkPage"  v-if="showDivEdit">
            <el-form ref="workEditForm" :model="workEditForm" label-width="80px">
                <el-form-item label="作业名称"  style="padding-top:30px;" >
                  <el-input v-model="workEditForm.workName" placeholder="输入作业名称"></el-input>
                </el-form-item>
            <el-form-item label="作业简介">
               <el-input type="textarea" v-model="workEditForm.workDetail"></el-input>
            </el-form-item>
            <el-form-item label="截止日期">
                <el-col :span="11">
                    <el-date-picker type="date" placeholder="选择日期" v-model="workEditForm.workDate" 
                      value-format="yyyy-MM-dd" style="width: 100%;"></el-date-picker>
                </el-col>        
            </el-form-item>
             <el-form-item label="满分值" style="width:150px">
                <el-input  v-model="workEditForm.fullGrade"></el-input>
            </el-form-item>

            <el-form-item style="margin-bottom:2px;margin-right:1100px;">
          
                <el-upload
                   class="avatar-uploader"
                   action="http://127.0.0.1:8080/file/upload2"
                  :show-file-list= "true"
                  :on-success="handleAvatarSuccess">
                  <el-button size="small" type="primary">导入作业</el-button>
                </el-upload>
            </el-form-item>

            <el-form-item style="margin-left: 600px;">
              <el-button type="primary" @click="submitEdit">保存</el-button>
              <el-button @click="jumpIndex()">取消</el-button>
            </el-form-item>
            </el-form>
        </div>


  

        <!--  <div class="workpage" v-for="(item,index) in allWork">
          <el-row style="height:50px">
            <el-col :span="1.5" 
               style="font-size:13px;margin-top:15px;background-color:#E9EEF3; line-height: 36px;margin-right:50px;">
              <div class="grid-content bg-purple-dark">
                个人作业</div></el-col>
            
            <el-col :span="1" style="margin-top:15px; margin-left:600px;">
              <div class="grid-content bg-purple-dark">
                    <el-dropdown>
                        <span class="el-dropdown-link">
                          <i class="el-icon-more"></i>
                        </span>
                        <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item> <el-button @click="toEditWork(item.workId)">编辑</el-button></el-dropdown-item>
                        <el-dropdown-item> <el-button @click="toDeleteWork(item.workId)">删除</el-button></el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
              </div>
            </el-col>
          </el-row>
          
          <el-row >
            <el-col :span="24" style="height:50px">
              <div class="grid-content bg-purple">
                 <a @click="jumpToDetail(item.workId)" style="cursor: pointer" >{{item.workName}}</a></div>
            </el-col>
            
          </el-row>
          
           <el-row  style="height:80px">
            <el-col :span="24"><div class="grid-content bg-purple">{{item.workDetail}}</div></el-col>
           
            </el-col>
          </el-row>

          <el-row  style="height:20px">
            <el-col :span="24"><div class="grid-content bg-purple" style="color:#BFC8D1 ">
              截止日期 {{item.workDate}}</div></el-col>
           
            <el-col :span="2"><div class="grid-content bg-purple"></div></el-col>
            <el-col :span="2"><div class="grid-content bg-purple"></div></el-col>
          </el-row>
        </div>  -->

        <div class="workpage" v-for="(item,index) in allWork">
          <div style="height:50px">
              <div style="font-size:13px;margin-left:50px;margin-top:15px;background-color:#E9EEF3; line-height: 36px;width:7%;float:left">
                个人作业
              </div>

               <div style="font-size:12px;margin-top:15px;line-height: 36px;width:20%;float:left">
                {{item.publishTime}}
              </div>
              

              <div style="float:left;margin-left:550px;margin-top:15px;width:5%;background-color:#E9EEF3;">
                <div>
                    <el-dropdown>
                        <span class="el-dropdown-link" style="cursor:pointer">
                          <i class="el-icon-more"></i>
                        </span>
                        <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item> <el-button @click="toEditWork(item.workId)">编辑</el-button></el-dropdown-item>
                        <el-dropdown-item> <el-button @click="toDeleteWork(item.workId)">删除</el-button></el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                </div>
              </div>
          </div>


         
           
         
          
          <div>
            <div style="height: 80px"> 
                 <div style="padding-right: 700px;">
                    <a @click="jumpToDetail(item.workId)" style="cursor: pointer" >{{item.workName}}</a>
                 </div>
                <div>
                 <span style="padding-right: 365px;">
                    {{item.workDetail}}
                 </span>
                </div> 
            </div>
            
          </div>
          
          <div>
              
              <span style="padding-right: 600px; font-size: 14px; color:#C2C9D0 ">  截止日期 {{item.workDate}}</span>

          </div>

          
        </div>

        <div class="bottom">

        </div>
        
      </div>

     
    

    </el-main>
  </el-container>



</template>
<script>
import {postRequest} from '../utils/api'
export default {
      data() {
      return {
        showDivEdit: false,
        showDivAdd: false,
        drawer: false,
        direction: 'ltr',
        courseName: this.$route.params.courseName,
        courseForm: {},
        workAddForm: {},
        workEditForm: {},
        allWork: {},
        workId: '',
        fileUrl:'',
        
      };
    },
    methods: {
      handleClose(done) {
       done();
      },

      /*跳出add窗口*/
      toAddWork() {   
        this.showDivAdd = true;
      },
      
      toEditWork(workId) {
        this.showDivEdit = true;
        this.getWorkById(workId);
      
      },

      jumpIndex() {
         this.showDivAdd = false;
         this.showDivEdit = false;
         this.getAllWorks();
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

      submitAdd() {
        this.$axios
        postRequest("/work/addWork", {
          workName: this.workAddForm.workName,
          workDetail: this.workAddForm.workDetail,
          workDate: this.workAddForm.workDate,
          course: this.courseForm.courseName,
          fullGrade: this.workAddForm.fullGrade,
          workFile: this.workAddForm.workFile
        })
        .then(res => {
        
          alert("添加成功");
          this.jumpIndex();
        
        })
        .catch(err => {
          alert(err.response.data.msg);
          console.log(err);
        });
      },

      submitEdit() {
        this.$axios
        postRequest("/work/updateWork", {
          workId: this.workEditForm.workId,
          workName: this.workEditForm.workName,
          workDetail: this.workEditForm.workDetail,
          workDate: this.workEditForm.workDate,
          fullGrade: this.workEditForm.fullGrade,
          workFile: this.workEditForm.workFile
        })
        .then(res => {
        
          alert("编辑成功");
          this.jumpIndex();
        
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
          this.allWork =res.data
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

      toDeleteWork(workId) {

        this.$confirm('您确定将删除该作业 '+' ,是否继续？','提示',{type:'warning'})
          .then(()=>{
              this.$axios
                 postRequest("/work/deleteWork", {workId: workId,})     
                 .then(res=>{
                  alert("删除成功");
                  this.jumpIndex();
                })
          
              .catch(err => {
                alert(err.response.data.msg);
                console.log(err);
               });
          })

      },

      jumpToDetail(workId) {
        this.$router.push('/correctPage/' + workId)
      },

      handleAvatarSuccess(res, file) {
        this.fileUrl = URL.createObjectURL(file.raw);
        this.workEditForm.workFile=res;
         this.workAddForm.workFile=res;
           this.$message({
            message: '上传成功',
            type: 'success'
          });
      },
     
      


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
    background: url("//assets.ketangpai.com/theme/teacher/big/23.png");
    
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
    height:450px;
  
    background-color: #FFFFFF; 
    border-radius: 10px 10px 10px 10px;
    box-shadow: 0 1px 2px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04) 
  }

  .editWorkPage {
    height:450px;
  
    background-color: #FFFFFF;  
    border-radius: 10px 10px 10px 10px;
    box-shadow: 0 1px 2px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04) 
  }

  .workbanner{
    width: auto;
    height: 85px;
    background-color: #FFFFFF;
    
  }
 

  .workpage{
    margin-top: 30px;
    height:150px;
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