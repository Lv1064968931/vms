<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 编辑预约信息 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form:form action="/appointment/update" modelAttribute="appointment"  id="admin-form" name="addForm">
                    <form:hidden path="id"/>
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 基本信息 </span>
                        </div>
                        <div class="section row">
                        <div class="col-md-6">
                            <label for="name" class="field prepend-icon">
                                <form:input path="name" cssClass="gui-input" placeholder="姓名..."/>
                                <label for="name" class="field-icon">
                                    <i class="fa fa-user"></i>
                                </label>
                            </label>
                        </div>
                        <div class="col-md-6">
                            <label for="phoneNum" class="field prepend-icon">
                                <form:input path="phoneNum" class="gui-input" placeholder="联系方式..."/>
                                <label for="phoneNum" class="field-icon">
                                    <i class="fa fa-user"></i>
                                </label>
                            </label>
                        </div>
                    </div>
                    <div class="section row">
                            <div class="col-md-6">
                                <label for="vaccineName" class="field prepend-icon">
                                    <form:input path="vaccineName" class="gui-input" placeholder="疫苗名称..."/>
                                    <label for="vaccineName" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        <div class="col-md-6">
                            <label for="location" class="field prepend-icon">
                                <form:input path="location" cssClass="gui-input" placeholder="接种地点..." />
                                <label for="location" class="field-icon">
                                    <i class="fa fa-user"></i>
                                </label>
                            </label>
                        </div>
                    </div>
                    <div class="panel-footer text-right">
                        <div class="panel-footer text-right">
                            <button type="submit" class="button"> 保存 </button>
                            <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom.jsp"/>