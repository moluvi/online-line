<template>
    <el-container>
        <el-header height="80px">
           <el-menu class="el-menu-demo" mode="horizontal" @select="" style="float:left;width:87%">
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
                        <el-menu-item style="margin-left: 1000px;"><el-button  @click="handleAddBox()" style="color:white;background-color:#5788B9">
                          <i class="el-icon-plus" style="color:white"></i>创建课程</el-button></el-menu-item>
                        <el-menu-item style="padding: 0; "><el-button style="color:white;background-color:#5788B9">
                          <i class="el-icon-plus" style="color:white; "></i>发布活动</el-button></el-menu-item>
                        

                    </el-menu>
                </el-header>
    
                <el-main class="ktcon">
                    <div class="box-card" v-for="(item,index) in allCourse">
                        <div slot="header" class="clearfix" style="padding: 0">
                            <el-row :gutter="10">
                              <el-col :span="12"><div class="grid-content bg-purple" style="margin-right: 30px; margin-top:10px; font-size: 25px">
                                <a @click="jumpToDetail(item.courseName)" style="cursor: pointer" >{{item.courseName}}</a></div></el-col>
                              <el-col :span="3"><div class="grid-content bg-purple" style="margin-left: 108px">
                                  <div class="bigDiv teacl">
	                                  <div class="squr"></div>
					                          <div class="ju">教</div>
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
                                      <el-button  @click="handleEditBox(item.courseName)">编辑</el-button>
                                    </el-dropdown-item>
                                    <el-dropdown-item><el-button  @click="deleteCourse(item.courseName)">删除</el-button> 
                                    </el-dropdown-item>
                                    <el-dropdown-item><el-button >归档</el-button> 
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


              <el-dialog title="新建课程"
              :visible.sync="addFormVisible" >
                <el-form ref="courseAddForm" :model="courseAddForm" label-width="80px">
                  <el-form-item label="课程名称">
                    <el-input v-model="courseAddForm.courseName"></el-input>
                  </el-form-item>
                  <el-form-item label="班级名称">
                    <el-input v-model="courseAddForm.courseClass"></el-input>
                  </el-form-item>
                  <el-form-item label="加课时间">
                      <el-col :span="11">
                        <el-select v-model="courseAddForm.courseYear" placeholder="请选择学年" style="width:240px;">
                          <el-option label="2019-2020" value="2019-2020"></el-option>
                          <el-option label="2018-2019" value="2018-2019"></el-option>
                          <el-option label="2017-2018" value="2017-2018"></el-option>
                          <el-option label="2016-2017" value="2016-2017"></el-option>
                        </el-select>
                      </el-col>
                         <el-select v-model="courseAddForm.courseTerm" placeholder="请选择学年" style="width:240px;">
                          <el-option label="第一学期" value="第一学期"></el-option>
                          <el-option label="第二学期" value="第二学期"></el-option>
                        </el-select>
                    
                  </el-form-item>
                
                  <el-form-item>
                    <el-button type="primary" @click="submitAdd">立即创建</el-button>
                    <el-button @click="jumpToList" >取消</el-button>
                  </el-form-item>
                </el-form>
            </el-dialog>

            

              <el-dialog title="编辑课程"
              :visible.sync="editFormVisible" >
                <el-form ref="courseEditForm" :model="courseEditForm" label-width="80px">
                  <el-form-item label="课程名称">
                    <el-input v-model="courseEditForm.courseName"></el-input>
                  </el-form-item>
                  <el-form-item label="班级名称">
                    <el-input v-model="courseEditForm.courseClass"></el-input>
                  </el-form-item>
                  <el-form-item label="加课时间">
                      <el-col :span="11">
                        <el-select v-model="courseEditForm.courseYear" placeholder="请选择学年" style="width:240px;">
                          <el-option label="2019-2020" value="2019-2020"></el-option>
                          <el-option label="2018-2019" value="2018-2019"></el-option>
                          <el-option label="2017-2018" value="2017-2018"></el-option>
                          <el-option label="2016-2017" value="2016-2017"></el-option>
                        </el-select>
                      </el-col>
                         <el-select v-model="courseEditForm.courseTerm" placeholder="请选择学年" style="width:240px;">
                          <el-option label="第一学期" value="第一学期"></el-option>
                          <el-option label="第二学期" value="第二学期"></el-option>
                        </el-select>
                      <el-col :span="11">
                      
                      </el-col>
                  </el-form-item>
                  <el-form-item>
                    <el-button type="primary" @click="submitEdit">立即编辑</el-button>
                    <el-button @click="jumpToList" >取消</el-button>
                  </el-form-item>
                </el-form>
            </el-dialog>

         </el-main>


       </el-container>  
</template>



<script>
import {postRequest} from '../utils/api'
import axios from 'axios'
export default {
    data() {
    return {
      addFormVisible: false,//是否显示窗口
      editFormVisible: false,
      username: this.$route.params.name,
      type: '',
      allCourse: {},
      courseAddForm: {},
      courseEditForm: {},
      courseName: '',
      courseId: '',
     
    }
  },    
  methods: {

    jumpToList() {
      this.addFormVisible= false;
      this.editFormVisible= false;
      this.getCourses();
    },

    jumpToDetail(courseName) {
     
       this.$router.push('/coursePageTeacher/' + courseName)
    },

    makeid() {
      var text = "";
      var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
      for( var i=0; i < 5; i++ )
        text += possible.charAt(Math.floor(Math.random() * possible.length));
        
      this.courseAddForm.courseNO = text;
    },
     
     exitSystem () {
      this.$router.replace('/login_page')
    },
    
     getCourses() {
      postRequest("/course/getCoursesByTeacher", {
        teachername: this.username,
      }) 
      .then(res => {
        
        console.log(res);
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

    handleEditBox(courseName) {
       this.editFormVisible = true;
       this.getCourseByName(courseName);
    },

   
    
    getCourseByName(courseName) {

      
      postRequest("/course/getCourseByName", {courseName: courseName})      
      .then(res => {
        
        console.log(res);
        this.courseEditForm = res.data;
      })
      .catch(err => {
        alert(err.response.data.msg);
        console.log(err);
      });
    },


    

    submitAdd() {
      
      this.makeid();
      this.addCourse();
    },

    submitEdit() {
      this.editCourse();
    },

    addCourse() {
        
       this.$axios
        postRequest("/course/addCourse", {
           courseName: this.courseAddForm.courseName,
          courseClass: this.courseAddForm.courseClass,
          courseNO: this.courseAddForm.courseNO,
          courseYear: this.courseAddForm.courseYear,
          courseTerm: this.courseAddForm.courseTerm,
          teacher: this.username
      })
        .then(res => {
        
          alert("创建课程成功！");
          this.$message({
            message: '创建成功',
            type: 'success'
          });
          this.jumpToList();
        
        })
        .catch(err => {
          alert(err.response.data.msg);
          console.log(err);
        });
    },

        
      
      
      editCourse() {  
        this.$axios
        postRequest("/course/updateCourse", {
          
          courseId: this.courseEditForm.courseId,
          courseName: this.courseEditForm.courseName,
          courseClass: this.courseEditForm.courseClass,
          courseYear: this.courseEditForm.courseYear,
          courseTerm: this.courseEditForm.courseTerm,

      })
        .then(res => {
        
          alert("编辑成功");
          this.jumpToList();
        
        })

        .catch(err => {
          alert(err.response.data.msg);
          console.log(err);
        });
      },

      
      
      deleteCourse(courseName) {


        
       this.$confirm('确定要删除这门课程吗？', '提示', {
        confirmButtonText: '退出',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
         postRequest("/course/deleteCourse", {
          courseName: courseName,
        }).then(res => {
         
          alert("删除成功");
          this.jumpToList();
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
       
    },    
    mounted() {
     this.getCourses();
    },


 
}
</script>
<style scoped>

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