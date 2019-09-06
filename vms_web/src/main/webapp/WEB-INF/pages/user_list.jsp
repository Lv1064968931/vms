<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="top.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 所有用户 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel  heading-border">
                <div class="panel-menu">
                    <div class="row">
                        <div class="hidden-xs hidden-sm col-md-3">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default light" href="javascript:;" onclick="reload()" id="reload">
                                    <i class="fa fa-refresh"></i>
                                </button>
                                <button type="button" class="btn btn-default light" href="javascript:;" onclick="del()" id="delete_many">
                                    <i class="fa fa-trash"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-body pn">
                    <table id="message-table" class="table admin-form theme-warning tc-checkbox-1">
                        <thead>
                        <tr class="">
                            <th class="text-center hidden-xs">Select</th>
                            <th class="hidden-xs">账号</th>
                            <th class="hidden-xs">密码</th>
                            <th class="hidden-xs">用户类型</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${userlist}" var="dept">
                        <tr class="message-unread">
                            <td class="hidden-xs">
                                <label class="option block mn">
                                    <input type="checkbox" name="id" value="${dept.account}">
                                    <span class="checkbox mn"></span>
                                </label>
                            </td>
                            <td>${dept.account}</td>
                            <td>${dept.password}</td>
                            <td>${dept.type}</td>
                            <td>
                                <a href="/user/remove?account=${dept.account}">删除</a>
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<script type="text/javascript">
    var vaccount=document.getElementsByName("id");
    function del() {
        var romove = confirm("是否确认删除？");
        if (romove == true) {
            var accounts = "";
            var n = 0;
            for (var i = 0; i < vaccount.length; i++) {
                if (vaccount[i].checked == true) {
                    var account = vaccount[i].value;
                    if (n == 0) {
                        accounts += "accounts=" + account;
                    } else {
                        accounts += "&accounts=" + account;
                    }
                    n++
                }
            }
            $.get("/user/remove_many", accounts, function (data) {
                if (data == "ok") {
                    alert("删除成功");
                    location.reload();
                    $("input[name=account]".removeAttr("checked"));
                } else {
                    alert("请选中至少一行！"+vaccount.length)
                }
            });
            return true;
        }else{
            return false;
        }
    }
    function reload() {
        location.reload();
    }
</script>

<jsp:include page="bottom.jsp"/>