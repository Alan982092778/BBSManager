<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="x-admin-sm">
  
  <head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.1</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
   <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/xadmin.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/cookie.js"></script>
  </head>
  <body>
    <div class="x-body">
       <form class="layui-form">
       	 <div class="layui-form-item">
              <div class="layui-input-inline">
                  <input type="hidden" name="invitationId" required="" lay-verify="invitationId"
                  autocomplete="off" value="${invitation.invitationId }" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>
              </div>
          </div>
       
        	<div class="layui-form-item">
              <label for="invitationMessage" class="layui-form-label">
                  <span class="x-red">*</span>帖子信息
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="invitationMessage" name="invitationMessage" required="" lay-verify="invitationMessage"
                  autocomplete="off" class="layui-input" value="${invitation.invitationMessage }">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>帖子信息介绍
              </div>
          </div>
          <div class="layui-form-item">
              <label for="plantId" class="layui-form-label">
                  <span class="x-red">*</span>所属模块
              </label>
              <div class="layui-input-inline">
                  <select id="plateId" name="plateId" lay-verify="plateId">
             		<option value="0">请选择模块</option>
             		<c:forEach items="${plist }" var="p">
             			<c:if test="${invitation.plateId==p.plateId }" var="isRight">
             				<option value="${p.plateId }" selected="selected">${p.plateTitle}</option>
             			</c:if>
             			<c:if test="${!isRight }">
             				<option value="${p.plateId }">${p.plateTitle}</option>
             			</c:if>
             		</c:forEach>
             		</select>
				</div>
          </div>
          <div class="layui-form-item">
              <label for="categoryId" class="layui-form-label">
                  <span class="x-red">*</span>帖子分类
              </label>
             <div class="layui-input-inline">
             	<select id="categoryId" name="categoryId" lay-verify="categoryId">
             		<option value="0">请选择帖子主题</option>
             		<c:forEach items="${clist }"  var="cl">
             		<c:if test="${invitation.categoryId==cl.categoryId }" var="isO">
             			<option value="${cl.categoryId }" selected="selected">${cl.category}</option>
             		</c:if>
             		<c:if test="${!isO }">
             			<option value="${cl.categoryId }">${cl.category}</option>
             		</c:if>
             		</c:forEach>
             		
             		</select>
				</div>
          </div>
         
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="edit" lay-submit="">
                  修改
              </button>
          </div>
      </form>
    </div>
    <script>
  		//取出session
    	/* var thisSession = window.sessionStorage.getItem("user");
  		alert(thisSession); */
      layui.use(['form','layer'], function(){
          $ = layui.jquery;
        var form = layui.form
        ,layer = layui.layer;
      
        //自定义验证规则
        form.verify({
          nikename: function(value){
            if(value.length < 5){
              return '昵称至少得5个字符啊';
            }
          }
          ,pass: [/(.+){6,12}$/, '密码必须6到12位']
          ,repass: function(value){
              if($('#L_pass').val()!=$('#L_repass').val()){
                  return '两次密码不一致';
              }
          }
        });
      	
        //监听提交
        form.on('submit(edit)', function(data){
          console.log(data);
          $.ajax({
          	url:"${pageContext.request.contextPath}/InvitationServerlt?op=updata",
          	type:"post",
          	data:data.field,
          	dataType:"text",
          	success:function(text){
          		if(text.trim()=="true"){
          			layer.alert("修改成功", {icon: 6},function () {
	                        //关闭当前frame
	                        x_admin_close();
	                        // 可以对父窗口进行刷新 
	                        x_admin_father_reload();
	                    }); 
          		}else{
          			layer.alert("修改失败", {icon: 2},function () {
	                        //关闭当前frame
	                        x_admin_close();
	                        // 可以对父窗口进行刷新 
	                        x_admin_father_reload();
	                    }); 
          		}
          		//thisSession.clear();
          	}
          });
          return false;
        });
        
      });
  </script>
  </body>
</html>