<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 添加疫苗环境 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form:form action="/vaccine_environment/add" modelAttribute="vaccine_environment"  id="admin-form" name="addForm">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 环境信息 </span>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="name" class="field prepend-icon">
                                    <form:input path="name" cssClass="gui-input" placeholder="名称..." />
                                    <label for="name" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="minTem" class="field prepend-icon">
                                    <form:input path="minTem" class="gui-input" placeholder="最低温度..."/>
                                    <label for="minTem" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label for="maxTem" class="field prepend-icon">
                                    <form:input path="maxTem" class="gui-input" placeholder="最高温度..."/>
                                    <label for="maxTem" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                            <label for="minHum" class="field prepend-icon">
                                <form:input path="minHum" cssClass="gui-input" placeholder="最低湿度..."/>
                                <label for="maxTem" class="field-icon">
                                    <i class="fa fa-user"></i>
                                </label>
                            </label>
                            </div>
                            <div class="col-md-6">
                                <label for="maxTem" class="field prepend-icon">
                                    <form:input path="maxHum" cssClass="gui-input" placeholder="最高湿度..."/>
                                    <label for="maxTem" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="minIllu" class="field prepend-icon">
                                    <form:input path="minIllu" cssClass="gui-input" placeholder="最低光照..."/>
                                    <label for="maxTem" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label for="maxIllu" class="field prepend-icon">
                                    <form:input path="maxIllu" cssClass="gui-input" placeholder="最高光照..."/>
                                    <label for="maxTem" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
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