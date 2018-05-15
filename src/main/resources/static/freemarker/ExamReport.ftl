<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>考试报表</title>
  <style>
    td {
      text-align: center;
    }
  </style>
</head>

<body>
  <div style="border: solid black 2px; width: 550px;">
    <table style="width: 100%">
      <tr>
        <td colspan="3">
          <h2>${examName}<br>考试报表</h2>
        </td>
      </tr>
      <tr>
        <td>考试编号:</td>
        <td style="border-bottom:1px solid;">
          ${examId}
        </td>
      </tr>
      <tr>
        <td>考试名称:</td>
        <td style="border-bottom:1px solid;">
          ${examName}
        </td>
      </tr>
      <tr>
        <td>考试类型:</td>
        <td style="border-bottom:1px solid;">
          ${examType}
        </td>
      </tr>
	  <tr>
        <td>参考人数:</td>
        <td style="border-bottom:1px solid;">
          ${examNum}
        </td>
      </tr>
      <tr>
        <td>总/通过分数:</td>
        <td style="border-bottom:1px solid;">
          ${totalScore}/${paseScore}
        </td>
      </tr>
	  <tr>
        <td>通&nbsp;&nbsp;过&nbsp;&nbsp;率:</td>
        <td style="border-bottom:1px solid;">
          ${paseRat}
        </td>
      </tr>
      <tr>
        <td>考试地点:</td>
        <td style="border-bottom:1px solid;" colspan="2">
          ${examPlace}
        </td>
      </tr>
    </table>
    <table style="width: 100%; table-layout: fixed;" border="1" cellspacing="0">
      <tr>
        <td>考试日期:</td>
        <td>${day1}</td>
        <td>${day2}</td>
        <td>${day3}</td>
      </tr>
      <tr>
        <td>考试时间:</td>
        <td>${time1}</td>
        <td>${time2}</td>
        <td>${time3}</td>
      </tr>
      <tr>
        <td>考试内容:</td>
        <td>${type1}</td>
        <td>${type2}</td>
        <td>${type3}</td>
      </tr>
    </table>
	<hr>
    <table style="width: 100%" border="1" cellspacing="0">
      <tr>
        <td colspan="3">具体情况</td>
      </tr>
	  <tr>
        <td>考生姓名</td>
		<td>准考证号</td>
		<td>考试成绩</td>
      </tr>
      <#list examineeInfo as examinee>
		  <tr>
	        <td>${examinee.userName}</td>
			<td>${examinee.admissionTicket}</td>
			<#if (examinee.score >= paseScore)>
				<td>${examinee.score}</td>
			<#else>
				<td><font color="red">${examinee.score}</font></td>
			</#if>
	      </tr>
      </#list>
    </table>
  </div>

</body>

</html>