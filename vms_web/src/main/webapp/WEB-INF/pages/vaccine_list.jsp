<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 疫苗信息 </h2>
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
                                    <i class="fa fa-plus" onclick="javascript:window.location.href='/vaccine/to_add';"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-footer clearfix">
                    <span id="sp" style="text-align: center;display: block;color: #FD482C;margin-right: 100px;margin-bottom: 4px;">${sessionScope.warning}</span>
                </div>
                <div class="panel-body pn">
                    <table id="message-table" class="table admin-form theme-warning tc-checkbox-1">
                        <thead>
                        <tr class="">
                            <th class="text-center hidden-xs">Select</th>
                            <th class="hidden-xs">RFID编号</th>
                            <th>名称</th>
                            <th class="hidden-xs">状态</th>
                            <th class="text-center">生产日期</th>
                            <th class="hidden-xs">保质期</th>
                            <th class="text-center">过期时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${vaccinelist}" var="cv">
                        <tr class="message-unread">
                            <td class="hidden-xs">
                                <label class="option block mn">
                                    <input type="checkbox" name="id" value="${cv.id}">
                                    <span class="checkbox mn"></span>
                                </label>
                            </td>
                            <td>${cv.rfidSn}</td>
                            <td>${cv.name}</td>
                            <td class="hidden-xs">
                                <span class="badge badge-warning mr10 fs11">${cv.status}</span>
                            </td>
                            <td><spring:eval expression="cv.productionDate"/></td>
                            <td class="text-center fw600">${cv.guaranteeDate}</td>
                            <td><spring:eval expression="cv.expirationDate"/></td>
                            <td>
                                <a href="/vaccine/to_update?id=${cv.id}">编辑</a>
                                <a href="/vaccine/remove?id=${cv.id}">删除</a>
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
    $.get("/vaccine/remove_many", ids, function (data) {
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
