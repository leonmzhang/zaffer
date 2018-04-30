HEADER_LINE_DIV_PREFIX = "headerDiv";
DELETE_BUTTON_PREFIX = "delBt";

mapObj = new Map([['key1', 'value1'], ['key2', 'value2']]);
mapObj.set('key3', 'value3');

headerId = 0;

function doRequest() {
    var url = $("#ipt_url").val();
    var method = $("#slct_method").val();
    //alert(method);

    var request = new XMLHttpRequest();
    /*request.onreadystatechange = function () {
        if (request.readyState == 4 && request.status == 200) {
            alert("response");
        }
    };*/


    request.onload = function () {
        alert(request.status);
    }
    request.onerror = function () {
        alert("error: " + request.status);
    }
    request.open(method, url, true);
    //request.setRequestHeader("Access-Control-Allow-Origin", "http://www.baidu.com")
    //request.setRequestHeader("Access-Control-Allow-Origin", "*");
    request.send("");
}

function addHeaderLineJQuery() {
    var $headerLineDiv = $("<div></div>");
    var $headerCheckbox = $("<input type='checkbox' />");
    var $headerKey = $("<input />");
    var $headerValue = $("<input />");
    var $headerRemoveButton = $("<button>X</button>");
    $headerRemoveButton.click(delHeaderLineJQuery);

    $headerLineDiv.append($headerCheckbox);
    $headerLineDiv.append($headerKey);
    $headerLineDiv.append($headerValue);
    $headerLineDiv.append($headerRemoveButton);

    $("#div_header").append($headerLineDiv);
}

function delHeaderLineJQuery(e) {
    var e = e || window.event;
    var btObj = e.target || e.srcElement;
    $(btObj.parentElement).remove();
}

function addHeaderLine() {
    var headerLineDivId = HEADER_LINE_DIV_PREFIX + headerId;
    var delBtId = DELETE_BUTTON_PREFIX + headerId;

    var headerCheckbox = document.createElement("input");
    headerCheckbox.setAttribute("type", "checkbox");
    //headerCheckbox.type = "checkbox";

    var headerKeyInput = document.createElement("input");
    var headerValueInput = document.createElement("input");

    var removeButton = document.createElement("button");
    removeButton.setAttribute("id", delBtId);
    removeButton.innerHTML = 'X';
    removeButton.onclick = delHeaderLine;

    var headerLineDiv = document.createElement("div");
    headerLineDiv.setAttribute("id", headerLineDivId);
    headerLineDiv.appendChild(headerCheckbox);
    headerLineDiv.appendChild(headerKeyInput);
    headerLineDiv.appendChild(headerValueInput);
    headerLineDiv.appendChild(removeButton);

    mapObj.set(delBtId, headerLineDivId);
    return headerLineDiv;
}

function delHeaderLine(e) {
    var e = e || window.event;
    var btObj = e.target || e.srcElement;
    var idStr = btObj.getAttribute('id');
    var divStr = mapObj.get(idStr);
    var divObj = document.getElementById(divStr);
    while (divObj.hasChildNodes()) {
        divObj.removeChild(divObj.firstChild);
    }

    var element = document.getElementById("div_header");
    element.removeChild(divObj);
}

//window.spaRouters = new SpaRouters();
// 简写, 也可以写成$(document).ready(function fn() {});
$(function () {
    $("#bt_add_header").click(function () {

        /*var element = document.getElementById("div_header");
        element.appendChild(addHeaderLine());*/
        addHeaderLineJQuery();
    });

    /*var element = document.getElementById("div_header");
    element.appendChild(addHeaderLine());*/
    addHeaderLineJQuery();

    $("#bt_send").click(doRequest);

});