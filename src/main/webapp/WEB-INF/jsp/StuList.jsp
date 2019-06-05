<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<html>
<head>
    <title>学生列表</title>
    <link rel="stylesheet" href="/css/bootstrap.css"/>
    <script src="/js/jquery-3.3.1.js"></script>
    <script src="/js/jqPaginator.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/dataTables.bootstrap-1.10.13.js"></script>

</head>
<body>
<div  class="container">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">

                <a class="navbar-brand" href="/stu/AllStuList">
                    练习两年半的偶像练习生列表
                </a>
                <button class="btn btn-success navbar-btn" data-toggle="modal" data-target=".bs-example-modal-lg">新增</button>
                <form action="/stu/QLike" method="post" style="margin:0px;display:inline;">
                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                <input type="text" name="search" placeholder="通过姓名关键字搜索">
                <button type="submit" class="btn btn-info navbar-btn">搜索</button>
                </form>
                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                <input type="button" class="btn btn-danger" onclick="logout()" value="注销账户">
            </div>
        </div>
    </nav>
<table class="table">
    <thead>
        <tr>
            <th>id</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>班级</th>
            <th>创建时间</th>
            <th>修改时间</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${PageInfo.list}" var="stu">
        <tr>
            <td>${stu.id}</td>
            <td>${stu.name}</td>
            <td>${stu.sex}</td>
            <td>${stu.age}</td>
            <td>${stu.className}</td>
            <td>${stu.creationTime}</td>
            <c:if test="${empty stu.updateTime}">
            <td>未修改</td>
            </c:if>
            <c:if test="${not empty stu.updateTime}">
                <td>${stu.updateTime}</td>
            </c:if>

            <c:if test="${stu.status==1}">
            <td>
                <button class="btn btn-danger" onclick="del(${stu.id})">删除</button>
                <button class="btn btn-info" onclick="update(${stu.id})">修改</button>
                <button class="btn btn-success" onclick="CloseStu(${stu.id})">封印</button>
            </td>
            </c:if>
            <c:if test="${stu.status==0}">
            <td>
                <button class="btn btn-danger" onclick="OpenStu(${stu.id})">解封</button>
            </td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>

<%--新增学生模态框--%>
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">新增学生</h4>
            </div>
            <div class="modal-body">
                <div>
                    <span>姓名：</span>
                    <input type="text" name="name" placeholder="请输入姓名">
                </div>
                <div>
                    <span>性别：</span>
                    <input type="text" name="sex" placeholder="请输入性别">
                </div>
                <div>
                    <span>年龄：</span>
                    <input type="text" name="age" placeholder="请输入年龄">
                </div>
                <div>
                    <span>班级：</span>
                    <input type="text" name="className" placeholder="请输入班级">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="add">确认</button>
                <button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<%--</form>--%>
<!-- 分页的导航栏 -->
<div class="pagination-layout container">

    <div class="pagination">
        <ul class="pagination">

        </ul>
    </div>
</div>


<%--分页--%>
<script>

    window.onload = function() {
        var if_fistime = true;
        $(".pagination")
            .jqPaginator(
                {
                    totalPages : ${PageInfo.pages},
                    visiblePages : 3,
                    currentPage : ${PageInfo.pageNum},
                    first : '<li class="first"><a href="javascript:void(0);">第一页</a></li>',
                    prev : '<li class="prev"><a href="javascript:void(0);">上一页</a></li>',
                    next : '<li class="next"><a href="javascript:void(0);">下一页</a></li>',
                    last : '<li class="last"><a href="javascript:void(0);">最后一页</a></li>',
                    page : '<li class="page"><a href="javascript:void(0);">{{page}}</a></li>',

                    onPageChange : function(num) {
                        /* alert(num); */
                        if (if_fistime) {
                            if_fistime = false;
                        } else {
                            changePage(num);
                        }
                    }
                })

    }

    function changePage(num) {
        window.location.href = "/stu/AllStuList?pageNum=" + num;
    }
</script>


<%--主页面js代码--%>
<script>
   function del(id){
       window.location.href="/stu/deleteStu?id="+id;

   }

   function update(id){
       window.location.href="/stu/GoUpdate?id="+id;

   }

   function OpenStu(id){
       window.location.href="/stu/OpenStu?id="+id;

   }

    function CloseStu(id){
        window.location.href="/stu/CloseStu?id="+id;

    }
   /*
    function searchName() {
        var name = $("input[name='search']").val();
        window.location.href="/stu/QLike?search="+name;
    }*/




</script>

<%--新增模态框js代码--%>
<script>
    $("#add").click(function () {
        var name = $("input[name='name']").val();
        var sex = $("input[name='sex']").val();
        var age = $("input[name='age']").val();
        var className = $("input[name='className']").val();
        if(name==null||name==undefined||name===''){
            alert("用户名为空");
            return;
        }
        if(sex==null||sex==undefined||sex===''){
            alert("性别为空");
            return;
        }
        if(age==null||age==undefined||age===''){
            alert("年龄为空");
            return;
        }
        if(className==null||className==undefined||className===''){
            alert("班级为空");
            return;
        }

        $.ajax({
            type: 'post',
            url: '/stu/addstu',
            data: {
                name: name,
                sex: sex,
                age: age,
                className: className
            },
            success: function () {
              window.location="/stu/AllStuList";
              alert("添加成功");
            }
        });

    })

</script>


<%--退出登录--%>
<script>
    function logout() {
        window.location.href="/admin/LoginOut";

    }

</script>


</body>
</html>
