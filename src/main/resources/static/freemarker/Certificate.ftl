<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>证书</title>
  <style>
    td {
      text-align: center;
    }
  </style>
</head>

<body>
  <div style="border: solid black 2px; width: 1100px; height: 600px">
	<br><br><br>
    <table style="width: 100%">
      <tr>
        <td colspan="3">
          <h2>${examName}<br>合格证书</h2>
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
        <td>考核结果:</td>
        <td style="border-bottom:1px solid;">
          合格
        </td>
      </tr>
    </table>
	<br>
	<hr>
    <table style="width: 100%" border="0" cellspacing="0">
      <tr>
        <td>
          <h2>参加${examName}，成绩合格，特此发证。</h2>
        </td>
      </tr>
    </table>
  </div>

</body>

</html>