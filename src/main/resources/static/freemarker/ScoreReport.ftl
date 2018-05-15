<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>成绩单</title>
  <style>
    td {
      text-align: center;
    }
  </style>
</head>

<body>
  <div style="border: solid black 2px; width: 550px; height: 700px">
    <table style="width: 100%">
      <tr>
        <td colspan="3">
          <h2>${examName}<br>成绩单</h2>
        </td>
      </tr>
      <tr>
        <td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</td>
        <td style="border-bottom:1px solid;">
          ${userName}
        </td>
        <td rowspan="4">
          <img src="${userPhoto}" style="width: 110px; height: 130px">
        </td>
      </tr>
      <tr>
        <td>准考证号:</td>
        <td style="border-bottom:1px solid;">
          ${admissionTicket}
        </td>
      </tr>
      <tr>
        <td>证件号码:</td>
        <td style="border-bottom:1px solid;">
          ${idCard}
        </td>
      </tr>
      <tr>
        <td>考试类型:</td>
        <td style="border-bottom:1px solid;">
          ${examType}
        </td>
      </tr>
	  <tr>
        <td>总/通过分数:</td>
        <td style="border-bottom:1px solid;" colspan="2">
          ${totalScore}/${paseScore}
        </td>
      </tr>
	  <tr>
        <td>是否有证书:</td>
        <td style="border-bottom:1px solid;" colspan="2">
          ${isCertificate}
        </td>
      </tr>
	  <tr>
        <td><h3>考生分数:</h3></td>
        <td style="border-bottom:1px solid;" colspan="2">
          <h3>${score}</h3>
        </td>
      </tr>
    </table>
	<br><br><br><br>
	<hr>
    <table style="width: 100%" border="1" cellspacing="0">
      <tr>
        <td>成绩单相关</td>
        <td>
          1. 考生根据自己的考试成绩以及通过分数即可判断本次考试是否通过。
          <br> 2. 若考生通过考试并且考试有相关的证书，则可以前往考生报名系统进行查看并下载。
          <br> ........
        </td>
      </tr>
    </table>
  </div>

</body>

</html>