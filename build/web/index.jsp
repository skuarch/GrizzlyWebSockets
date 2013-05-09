<%-- 
    Document   : index
    Created on : May 9, 2013, 6:29:19 PM
    Author     : skuarch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>skuarch</title>

        <script type="text/javascript">
            //ws = new WebSocket("ws://192.168.208.9:8080");
            ws = new WebSocket("ws://localhost:8080/GrizzlyWebSockets/webSocket");
            ws.onopen = function(e) {
                var resultAreaObj = document.getElementById('result');
                resultAreaObj.innerHTML += '<span class="log">onopen</span>' + '<br>'
            };
            ws.onclose = function(e) {
                var resultAreaObj = document.getElementById('result');
                resultAreaObj.innerHTML += '<span class="log">onclose</span>' + '<br>'
            };
            ws.onmessage = function(e) {
                var resultAreaObj = document.getElementById('result');
                resultAreaObj.innerHTML += e.data + '<br>'
            };
            ws.onerror = function() {
                var resultAreaObj = document.getElementById('result');
                resultAreaObj.innerHTML += '<span class="log">onerror</span>' + '<br>'
            };
            send = function() {
                var textFieldObj = document.getElementById('textField');
                var data = textFieldObj.value;
                if (data) {
                    ws.send(data);
                    //textFieldObj.value = '';
                }
            };

            //setInterval(function(){send()},300);

        </script>


    </head>
    <body>
        <h1>Grizzly WebSockets!</h1>

        <input type="text" name="textField" id="textField" size="50"/>
        <input type="button" id="send" value="enviar" onclick="send();"/>

        <hr/>

        <div id="result">
        </div>


    </body>
</html>
