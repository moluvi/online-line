<template>
  
  <el-container>

    <el-header>
        <el-menu class="el-menu-demo"  mode="horizontal" @select="">
            <el-menu-item>
              <i class="el-icon-back"></i>
            </el-menu-item>
            <el-menu-item style="margin-left: 500px">学生作业</el-menu-item>
            <el-menu-item>作业讨论</el-menu-item>
        </el-menu>
        <div class="line"></div>

        

    </el-header>

    
    
    <el-main>

      <div class="box">
        <div class="workHeader">
          
          <el-row :gutter="20">
            <el-col :span="16"><div class="grid-content bg-purple"></div></el-col>
            <el-col :span="8"><div class="grid-content bg-purple"></div></el-col>
          </el-row>
          
          <el-row :gutter="20">
            <el-col :span="8"><div class="grid-content bg-purple">{{workForm.workName}}</div></el-col>
            <el-col :span="8"><div class="grid-content bg-purple"></div></el-col>
            <el-col :span="4"><div class="grid-content bg-purple"></div></el-col>
           <el-col :span="4"><div class="grid-content bg-purple"></div></el-col>  
          </el-row>
          
          <el-row>
            <el-col :span="8"><div class="grid-content bg-purple">截至：{{workForm.workDate}}</div></el-col>
            <el-col :span="4"><div class="grid-content bg-purple"></div></el-col>
            <el-col :span="4"><div class="grid-content bg-purple"></div></el-col>
          </el-row>

      </div>
        
    
      <div>
           <el-table :data= "allReply" class="tb-edit" style="width: 100%" highlight-current-row @row-click="handleCurrentChange">
            <el-table-column label="学号" width="180" prop="studentNo">
            </el-table-column>
            <el-table-column label="姓名" prop="studentName">
            </el-table-column>
            <el-table-column label="成绩" width="180">
                <template slot-scope="scope">
                    <el-input size="small" v-model="scope.row.grade" placeholder="请输入内容" @change="handleEdit(scope.$index, scope.row)"></el-input> 
                </template>
            </el-table-column>
            <el-table-column label="姓名" prop="submitTime">
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button size="small" type="danger" @click="replyDownload(scope.$index, scope.row)">下载
                    </el-button>
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
  .tb-edit .current-row .el-input+span {
    display: none
  }
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
    background: #d3dce6;
  }

 
  .bg-purple-light {
    background: #e5e9f2;
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
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }
  
  .el-main {
    height: 700px;
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
      
  }
  
  
  .box {  
    margin-left: 285px;
    margin-top: 40px;
    width: 880px;
    border: 1px #909399 solid;
    box-sizing: border-box;
    height: 600px;
  }

  .workHeader{
    height: 150px;
    border-bottom: 1px #909399 solid;
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