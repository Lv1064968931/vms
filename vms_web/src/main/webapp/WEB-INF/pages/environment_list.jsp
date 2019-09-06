<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 环境信息 </h2>
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
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-body pn">
                    <table id="message-table" class="table admin-form theme-warning tc-checkbox-1">
                        <thead>
                        <tr class="">
                            <th class="text-center">Select</th>
                            <th class="text-center">时间</th>
                            <th class="text-center">温度</th>
                            <th class="text-center">湿度</th>
                            <th class="text-center">光照</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${environmentlist}" var="em">
                        <tr class="message-unread">
                            <td class="hidden-xs">
                                <label class="option block mn">
                                    <input type="checkbox" name="mobileos" value="FR">
                                    <span class="checkbox mn"></span>
                                </label>
                            </td>
                            <td class="text-center fw600"><spring:eval expression="em.time"/></td>
                            <td class="text-center fw600">${em.temperature}</td>
                            <td class="text-center fw600">${em.humidity}</td>
                            <td class="text-center fw600">${em.illumination}</td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<script>
    function reload() {
        location.reload();
    }
</script>

<jsp:include page="bottom.jsp"/>
