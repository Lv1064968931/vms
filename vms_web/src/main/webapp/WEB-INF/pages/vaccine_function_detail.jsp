<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 疫苗功能详细信息 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form:form action="/vaccine_function/detail" modelAttribute="vaccine_function_detail"  id="admin-form" name="addForm">
                    <form:hidden path="id"/>
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 基本信息 </span>
                        </div>
                    <div class="section row">
                        <div class="col-md-6">
                                <form:input path="name" cssClass="gui-input" placeholder="名称..." readonly="true"/>
                        </div>
                        <div class="col-md-6">
                                <form:input path="function" class="gui-input" placeholder="功能..." readonly="true"/>
                        </div>
                    </div>
                    <div class="section row">
                        <div class="col-md-6">
                                <form:input path="taboo" class="gui-input" placeholder="禁忌..." readonly="true"/>
                        </div>
                            <div class="col-md-6">
                                    <form:input path="standard" class="gui-input" placeholder="规格..." readonly="true"/>
                            </div>
                    </div>
                        <div class="section row">
                            <div class="col-md-6">
                                    <form:input path="untowardEffect" cssClass="gui-input" placeholder="不良反应..." readonly="true"/>
                            </div>
                            <div class="col-md-6">
                                    <form:input path="objectVaccine" cssClass="gui-input" placeholder="接种对象..." readonly="true"/>
                            </div>

                        </div>
                        <div class="panel-footer text-right">
                            <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom.jsp"/>