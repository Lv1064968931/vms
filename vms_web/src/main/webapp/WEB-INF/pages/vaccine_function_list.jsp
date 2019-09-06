<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 疫苗功能 </h2>
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
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-plus" onclick="javascript:window.location.href='/vaccine_function/to_add';"></i>
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
                            <th class="text-center">名称</th>
                            <th class="text-center">功能</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${vaccinefunctionlist}" var="vf">
                        <tr class="message-unread">
                            <td class="hidden-xs">
                                <label class="option block mn">
                                    <input type="checkbox" name="id" value="${vf.id}">
                                    <span class="checkbox mn"></span>
                                </label>
                            </td>
                            <td class="text-center">${vf.name}</td>
                            <td class="text-center">${vf.function}</td>
                            <td><a href="/vaccine_function/detail?id=${vf.id}">详细信息</a></td>
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
    var vid=document.getElementsByName("id");
    function del() {
        var romove = confirm("是否确认删除？");
        if (romove == true) {
            var ids = "";
            var n = 0;
            for (var i = 0; i < vid.length; i++) {
                if (vid[i].checked == true) {
                    var id = vid[i].value;
                    if (n == 0) {
                        ids += "ids=" + id;
                    } else {
                        ids += "&ids=" + id;
                    }
                    n++
                }
            }
            $.get("/vaccine_function/remove_many", ids, function (data) {
                if (data == "ok") {
                    alert("删除成功");
                    location.reload();
                    $("input[name=id]".removeAttr("checked"));
                } else {
                    alert("请选中至少一行！")
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
