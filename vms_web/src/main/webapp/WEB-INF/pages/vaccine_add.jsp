<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 添加疫苗 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form:form action="/vaccine/add" modelAttribute="vaccine"  id="admin-form" name="addForm">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 基本信息 </span>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="rfidSn" class="field prepend-icon">
                                    <form:input path="rfidSn" cssClass="gui-input" placeholder="RFID编号..." />
                                    <label for="rfidSn" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label for="name" class="field prepend-icon">
                                    <form:input path="name" class="gui-input" placeholder="名称..."/>
                                    <label for="name" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="status" class="field select">
                                    <form:select path="status" items="${status}" cssClass="gui-input" placeholder="状态..."/>
                                    <i class="arrow double"></i>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                            <label for="productionDate" class="field select">
                                <form:input path="productionDate" cssClass="gui-input" placeholder="生产日期..."/>
                            </label>
                            </div>
                            <div class="col-md-6">
                                <label for="guaranteeDate" class="field select">
                                    <form:input path="guaranteeDate" cssClass="gui-input" placeholder="保质期..."/>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="expirationDate" class="field select">
                                    <form:input path="expirationDate" cssClass="gui-input" placeholder="过期时间..."/>
                                </label>
                            </div>
                        </div>
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