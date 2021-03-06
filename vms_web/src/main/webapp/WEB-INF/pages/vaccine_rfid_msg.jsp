<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 疫苗信息 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form:form action="/vaccine/vaccine_rfid_msg" modelAttribute="vaccine_rfid"  id="admin-form" name="addForm">
                    <form:hidden path="id"/>
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 基本信息 </span>
                        </div>
                        <div class="section row">
                        <div class="col-md-6">
                            <label for="rfidSn" class="field prepend-icon">
                                <form:input path="rfidSn" cssClass="gui-input" placeholder="RFID编号..." readonly="true"/>
                                <label for="rfidSn" class="field-icon">
                                    <i class="fa fa-user"></i>
                                </label>
                            </label>
                        </div>
                        <div class="col-md-6">
                            <label for="name" class="field prepend-icon">
                                <form:input path="name" class="gui-input" placeholder="名称..." readonly="true"/>
                                <label for="name" class="field-icon">
                                    <i class="fa fa-user"></i>
                                </label>
                            </label>
                        </div>
                    </div>
                    <div class="section row">
                        <div class="col-md-6">
                            <label for="name" class="field prepend-icon">
                                <form:input path="status" class="gui-input" placeholder="状态..." readonly="true"/>
                                <label for="name" class="field-icon">
                                    <i class="fa fa-user"></i>
                                </label>
                            </label>
                        </div>
                            <div class="col-md-6">
                                <label for="name" class="field prepend-icon">
                                    <form:input path="productionDate" class="gui-input" placeholder="生产日期..." readonly="true"/>
                                    <label for="name" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                    </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="rfidSn" class="field prepend-icon">
                                    <form:input path="guaranteeDate" cssClass="gui-input" placeholder="保质期..." readonly="true"/>
                                    <label for="rfidSn" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label for="name" class="field prepend-icon">
                                    <form:input path="expirationDate" class="gui-input" placeholder="过期时间..." readonly="true"/>
                                    <label for="name" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
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