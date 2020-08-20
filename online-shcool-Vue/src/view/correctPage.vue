<template>
  
  <el-container>

    <el-header>
        <el-menu class="el-menu-demo"  mode="horizontal">
            <el-menu-item >
              <i class="el-icon-back"></i>
              <el-button round style="background-color:#317AC5; color:#ffffff;">熟悉课堂派</el-button>
            </el-menu-item>
            <el-menu-item style="margin-left:400px;border-bottom: 3px solid #136ECC;">学生作业</el-menu-item>
            <el-menu-item>作业讨论</el-menu-item>
        </el-menu>
        <div class="line"></div>

        

    </el-header>

    
    
    <el-main>

      <div class="box">
        <div class="workHeader">
          <div>
             <div style="width:300px;font-size:28px;color:#fff;padding-top:20px">{{workForm.workName}}</div>
          </div>
          
          <div style="margin-top:40px">

            <div style="width:250px;background-color:#E2E7EB;margin-left:30px;color:#96999C">截至：{{workForm.workDate}}</div>
            
          </div>

      </div>
        
    
      <div>
           <el-table :data= "allReply" class="tb-edit" style="width: 100%" highlight-current-row @row-click="handleCurrentChange">
            <el-table-column label="学号" width="180" prop="studentNo">
            </el-table-column>
            <el-table-column label="姓名" prop="studentName">
            </el-table-column>
            <el-table-column label="成绩" width="180">
                <template slot-scope="scope">
                    <el-input style="width:50px; float: left" v-model="scope.row.grade" placeholder="" @change="handleEdit(scope.$index, scope.row)"></el-input> 
                    <span style="margin-left:5px;float:left;height:40px;line-height:40px">/{{workForm.fullGrade}}</span>
                    
                </template>
            </el-table-column>
           
            <el-table-column label="提交时间" prop="submitTime">
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                  <el-button type="success" icon="el-icon-download" circle @click="replyDownload(scope.$index, scope.row)">查看作业</el-button>
                    
                </template>
            </el-table-column>
        </el-table>

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
        filename:'ss',
        fileUrl: '', 
        workForm: {},
        showDivEdit: false,
        workId: this.$route.params.workId,
        allReply: [],
       
      };
    },
    methods: {
     
       getWorkById() {         
        postRequest("/work/getWorkById", {
          workId: this.workId
        }) 
        .then(res => {
          console.log(res);
          this.workForm = res.data
        })
        .catch(err => {
          alert(err.response.data.msg);
          console.log(err);
        });

      },

      getAllReplys() {
          postRequest("/reply/getAllReplys", {
          workId: this.workId
        }) 
        .then(res => {
          console.log(res);
          this.allReply = res.data
        })
        .catch(err => {
          alert(err.response.data.msg);
          console.log(err);
        });
      },

      handleCurrentChange(row, event, column) {
          console.log(row, event, column, event.currentTarget)
      },
      
      handleEdit(index, row) {
          postRequest("/reply/updateGrade", {
            replyId: row.replyId,
            grade: row.grade
        }) 
        .then(res => {
          this.$message({
            type: 'success',
            message: '修改成功!'
          })
        })
        .catch(err => {
          alert(err.response.data.msg);
          console.log(err);
        });
      },

      replyDownload(index, row) {

        console.log(row.replyFile);
        window.location.href= row.replyFile;
      }

      
    
    },
    
    mounted() {
      this.getWorkById();
      this.getAllReplys();
      
    },
}
</script>
<style scoped>


  .tb-edit .el-input {
    display: block
  }
  .tb-edit .current-row .el-input {
    display: block
  }
  
  /* .tb-edit .current-row .el-input+span {display: none} */

  /* el-row 排布样式*/
  .el-row {
    margin-bottom:5px ;
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
   
    color: #333;
    text-align: center;
    line-height: 60px;
  }
  
  .el-main {
   
  
    color: #333;
    text-align: center;
      
  }
  
  
  .box { 
    border-radius: 8px 8px 0 0; 
    margin: auto;
    margin-top: 40px;
    width: 880px;
    border: 1px #909399 solid;
    box-sizing: border-box;
   
  }

  .workHeader{
    height: 150px;
    border-bottom: 1px #909399 solid;
    background: url("//assets.ketangpai.com/theme/teacher/big/19.png");
    border-radius: 8px 8px 0 0;
   
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