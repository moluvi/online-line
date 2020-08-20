<template>
    <el-container>
       <el-header height="80px">
            <el-menu class="el-menu-demo" mode="horizontal" @select="" style="float:left;width:90%">
                <el-menu-item style="margin-left: 35px"> <img src="../assets/logo.png" weight="41" height="22"/></el-menu-item>
                <el-menu-item index="1">课堂</el-menu-item>
                <el-menu-item index="2">备战区</el-menu-item>
                <el-menu-item index="3">我的精品</el-menu-item>
            
            </el-menu>

            <el-menu  class="el-menu-demo"  mode="horizontal" style="float:left">

                
                <el-menu-item style="margin-left: 0px">
                     <i class="el-icon-bell"></i>
                    <el-dropdown>
                         <img class="avatar" 
                        src="https://www.ketangpai.com/Public/Common/img/40/22.png">
                        <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item>设置</el-dropdown-item>
                        <el-dropdown-item>开通VIP</el-dropdown-item>
                        <el-dropdown-item><el-button @click="exitSystem()" type="text">退出登陆</el-button></el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                    <span style="margin-left:10px">{{this.username}}  </span>
                </el-menu-item>
               
            </el-menu>
        </el-header>
        
        
        
        <el-main style="line-height: 0px;">
            <el-container>

              
                <el-header height="60px">
                    <el-menu class="el-menu2" mode="horizontal">
               
                         <el-menu-item style="margin-left:20px;">所有课程</el-menu-item>
                         
                         <el-menu-item style="margin-left:1050px;">
                              <a @click="jumpToDrawnCourse()"><i class="el-icon-folder-opened">归档管理</i>
                              </a>  
                          </el-menu-item>
                         
                         <el-menu-item style="margin-left: 30px;"><el-button  @click="handleAddBox()" style="color:white;background-color:#5788B9">
                          <i class="el-icon-plus" style="color:white"></i>加入课程</el-button></el-menu-item>
                            
               

                    </el-menu>
                </el-header>

                <el-main class="ktcon">
                    <div class="box-card" v-for="(item,index) in allCourse">
                        <div slot="header" class="clearfix" style="padding: 0">
                            <el-row :gutter="10">
                              <el-col :span="12"><div class="grid-content bg-purple" style="margin-right: 30px; margin-top:10px; font-size: 25px">
                                <a @click="jumpToDetail(item.courseName)" style="cursor: pointer" >{{item.courseName}}</a></div></el-col>
                              <el-col :span="3"><div class="grid-content bg-purple" style="margin-left: 110px">
                                
                                  <div class="bigDiv teacl">
	                                  <div class="squr"></div>
					                        <div class="ju">学</div>
				                          </div>
                                </div></el-col>
                            </el-row>
                            <el-row :gutter="10">
                              <el-col :span="8"><div class="grid-content bg-purple" style="margin-left:25px;">{{item.courseClass}}</div></el-col>
                        
                            </el-row>


                             <el-row :gutter="10" >
                              <el-col :span="3">
                                <div class="grid-content bg-purple" style="margin-left: 180px;font-size: 13px; color: #B9C2CC">{{item.courseYear}}</div>
                              </el-col>
                            </el-row
                            >
                            <el-row>
                              <el-col :span="10">
                                <div class="grid-content bg-purple" style="margin-left: 10px;font-size: 14px">
                                  加课码：{{item.courseNO}}</div>
                              </el-col>
                              <el-col :span="12" style="margin-bootom:20px;"><div class="grid-content bg-purple" style=" margin-left: 50px; font-size: 13px;color: #B9C2CC ">
                                {{item.courseTerm}}
                                </div></el-col>
                            
                            </el-row>
                        </div>
                        <div class="text item">
                            <el-row :gutter="20">
                              <el-col :span="8" style=""><div class="grid-content bg-purple">近期作业</div></el-col>
                            </el-row>
                            <el-row :gutter="20">
                              <el-col :span="24"><div class="grid-content bg-purple">
                                  {{item.recentWork}}
                              </div></el-col>
                             
                            </el-row>
                         </div>

                         <div class="bottomInfo">
                             <el-row :gutter="2">
                              <el-col :span="6"><div class="grid-content bg-purple">成员：{{item.member}}</div></el-col>
                              <el-col :span="10"><div class="grid-content bg-purple"></div></el-col>
                              <el-col :span="8">
                                <div class="grid-content bg-purple" style="margin-left:30px">
                                  更多 
                                  <el-dropdown>
                                    <i class="el-icon-arrow-down el-icon--right" style="cursor:pointer"></i>                                
                                  <el-dropdown-menu slot="dropdown">
                                  <template slot-scope="scope">
                                    <el-dropdown-item>
                    
                                      <el-button  @click="drawnCourse(item.courseId)">归档</el-button>
                                    </el-dropdown-item>
                                    <el-dropdown-item><el-button  @click="deleteCourse(item.courseId)">退课</el-button> 
                                    </el-dropdown-item>
      
                                  </template>
                                  </el-dropdown-menu>
                                  </el-dropdown> 
                                </div></el-col>
                            </el-row>
                         </div>
                    </div>                    
                </el-main>

               
             </el-container>


              <el-dialog title="加入课程"
              :visible.sync="addFormVisible" >
                <el-form ref="courseJoinForm" :model="courseJoinForm" label-width="80px">
                  <el-form-item label="加课码">
                    <el-input v-model="courseJoinForm.courseNO"></el-input>
                  </el-form-item>          
                  <el-form-item>
                    <el-button type="primary" @click="submitAdd">加入</el-button>
                    <el-button @click="jumpToList" >取消</el-button>
                  </el-form-item>
                </el-form>
            </el-dialog>
         </el-main>

          
            <el-dialog 
                  :visible.sync="drawnVisible" >

               <div style="height:50px; ">
                  <span style="font-size:23px">归档管理</span>
               </div>

              <div style="height:500px" v-for="(item,index) in drawnCourses">
                  <div  class="ch" style="width:260px;height:120px;
                         " >
                      <div style="float:left;width:88%;color:#fff">

                          <div style="font-size:25px;width:50%">
                            {{item.courseName}}
                          </div>
                     
                          <div style="font-size:20px;margin-top:30px">
                              <div style="float:left;">
                                角色：学生
                              </div>
                              <div style="float:left;margin-left:10px">
                                老师：{{item.teacher}}
                              </div>
                          </div>
                      </div>

                      <div style="float:left;"> 
                          <el-dropdown>
                            <span class="el-dropdown-link" style="cursor:pointer">
                             <i class="el-icon-more" style="color:#fff"></i>
                        </span>
                        <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item> <el-button @click="toReCover(item.courseName)">恢复</el-button></el-dropdown-item>
                        <el-dropdown-item> <el-button @click="deleteCourseD(item.courseName)">退课</el-button></el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                      </div>

                  </div>

              </div>


            </el-dialog>


       </el-container>  
</template>



<script>
import {postRequest} from '../utils/api'
import axios from 'axios'
export default {
    data() {
    return {
      addFormVisible: false,//是否显示窗口
      username: this.$route.params.name,
      type: '',
      allCourse: {},
      courseJoinForm: {},
      courseCount: '',
      courseName: '',
      courseId: '',
      studentname: '',
      courseNO: '',
      drawnVisible: false,
      drawnCourses:''
    }
  },    
  methods: {
    
     toReCover(courseName) {


       this.$confirm('确定要恢复这门课程吗？', '提示', {
        confirmButtonText: '恢复',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        postRequest("/course/recoverCourse", {
          courseName: courseName,
          studentName: this.username,      
        },).then(res => {
          this.jumpToList()
        })
        this.$message({
          type: 'success',
          message: '恢复成功'
        })
         console.log(res);
         
      })
     
      .catch(err => {
        alert(err.response.data.msg);
        console.log(err);
      });
    },

    jumpToDrawnCourse() {
      this.getDrawnCourses();
      this.drawnVisible= true;
    },


    jumpToList() {
      this.addFormVisible= false;
      this.drawnVisible= false;
      this.getAllCourses();
      this.getDrawnCourses();
    },

    jumpToDetail(courseName) {
       this.$router.push(`/coursePageStudent/${courseName}/${this.username}`)
    },  
    
    exitSystem () {
      this.$router.replace('/login_page')
    },
    
    getAllCourses() {
    
      postRequest("/course/getCoursesByStudent", {
        studentname: this.username,
      },
      ) 
      .then(res => {
       
        this.allCourse =res.data
      })
      .catch(err => {
        alert(err.response.data.msg);
        console.log(err);
      });
    },

    handleAddBox() {
       this.addFormVisible = true;
    },

    submitAdd() {
      this.judgeCourse();
    },
    
    judgeCourse() {
       postRequest("/course/judgeCourse", {
        courseNO: this.courseJoinForm.courseNO,
      },
      ) 
      .then(res => {
        this.courseCount = res.data;
        console.log(res.data);
          
        if(this.courseCount == 0) {
          alert("不存在该门课程");
          this.jumpToList();
        }
        else {
          this.joinCourse();
        }
      })
      .catch(err => {
        alert(err.response.data.msg);
        console.log(err);
      });

    },

    joinCourse() {
      postRequest("/course/joinCourse", {
        courseNO: this.courseJoinForm.courseNO,
        studentName: this.username,
      },
      ) 
      .then(res => {
        console.log(res);
        this.$message('加课成功');
        this.jumpToList();
      })
      .catch(err => {
        alert(err.response.data.msg);
        console.log(err);
      });
    },

    deleteCourse(courseId) {


       this.$confirm('确定要退出这门课程吗？', '提示', {
        confirmButtonText: '退出',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        postRequest("/course/exitCourse", {
          courseId: courseId,      
        },).then(res => {
          this.getAllCourses()
        })
        this.$message({
          type: 'success',
          message: '退课成功!'
        })
         console.log(res);
         
      })
     
      .catch(err => {
        alert(err.response.data.msg);
        console.log(err);
      });
    },

     drawnCourse(courseId) {


       this.$confirm('确定要归档这门课程吗？', '提示', {
        confirmButtonText: '归档',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        postRequest("/course/drawnCourse", {
          courseId: courseId, 
          studentName: this.username,     
        },).then(res => {
          this.getAllCourses()
        })
        this.$message({
          type: 'success',
          message: '归档成功，可在归档管理界面查看'
        })
         console.log(res);
         
      })
     
      .catch(err => {
        alert(err.response.data.msg);
        console.log(err);
      });
    },

    getDrawnCourses() {
    
      postRequest("/course/getDrawnCourses", {
          studentName: this.username,
        
      },
      ) 
      .then(res => {
          this.drawnCourses =res.data
      })
      .catch(err => {
        alert(err.response.data.msg);
        console.log(err);
      });
    },

    deleteCourseD(courseName) {
       
        this.$confirm('确定要退出这门课程吗？', '提示', {
        confirmButtonText: '退出',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        postRequest("/course/drawnExitCourse", {
          courseName: courseName,
          studentName: this.username,     
        },).then(res => {
          this.jumpToList();
        })
        this.$message({
          type: 'success',
          message: '退出成功'
        })
         console.log(res);
         
      })
     
      .catch(err => {
        alert(err.response.data.msg);
        console.log(err);
      });

    }

    },

    

    mounted() {
     
      this.getAllCourses();
      this.getDrawnCourses();
    },

 
}
</script>
<style scoped>


.ch{
   background:url("//assets.ketangpai.com/theme/teacher/min/08.png") ;
}


.avatar {

    width: 30px;
    height: 30px;
    border-radius: 50%;
    margin-top: -3px;
    background-image: url(/Public/Common/img/avatarloading.gif);
    background-repeat: no-repeat;
    background-position: center;

}


.el-menu-item {
    font-size: 14px;
    color: #303133;
    padding: 0 30px;
    cursor: pointer;
    -webkit-transition: border-color .3s,background-color .3s,color .3s;
    transition: border-color .3s,background-color .3s,color .3s;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    height: 60px;
   
}

.el-header {
    background-color: #FFFFFF;
    color: #333;
    text-align: center;
    line-height: 60px;
    padding:0px;
  
  }
 .el-main {
    background-color: #FFFFFF;
    color: #333;
    text-align: center;
  }
.el-menu.el-menu--horizontal {
    border-bottom: solid 1px 
    #e6e6e6;
    box-shadow: 0 0px 0px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
}

.el-menu2.el-menu--horizontal {
   
}


 .text {
    font-size: 14px;
  }

  .item {
    
    height: 80px;
  }



.ktcon {
    display: flex;
    flex-wrap: wrap;
    height: 400px;
   
}

.bottomInfo {
   border-top: 0.5px solid #E0E0E0;

}

.clearfix {
  color: #FFFFFF;
  height: 150px;
  background-color: #409EFF;
  border: 1px solid #909399;
  border-radius: 5px;
  background: url("//assets.ketangpai.com/theme/teacher/min/08.png");
}
  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
     
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 280px;
    height:270px;
    margin-left: 20px;
    border: 2px solid #C8C8C8;
    border-radius: 10px;
    
  }

  .el-card__header {
    padding: 0px !important;
    border-bottom: 1px solid 
    #EBEEF5;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}


 .el-row {
   line-height: 10px;
    &:last-child {
      margin-bottom: 0;
    }
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
   
  }
  .bg-purple {
    
  }
  .bg-purple-light {
    
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
    line-height: 30px;
  }

   .el-dropdown {
    vertical-align: top;
  }
  .el-dropdown + .el-dropdown {
    margin-left: 15px;
  }
  .el-icon-arrow-down {
    font-size: 12px;
  }

  .teacl {
    width: 24px;
    height: 28px;
}

  .teacl .squr {
    width: 0;
    height: 0;
    border-left: 10px solid #fff;
    border-right: 10px solid
    #fff;
    position: absolute;
    z-index: 1;
    top: 21px;
    left: 15px;
}

  .teacl .ju {
    width: 20px;
    background: #fff;
    color:#2C58AB;
  }
</style>