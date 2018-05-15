<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>准考证</title>
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
          <h2>${examName}<br>准考证</h2>
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
        <td>考试地点:</td>
        <td style="border-bottom:1px solid;" colspan="2">
          ${examPlace}
        </td>
      </tr>
      <tr>
        <td>
          考&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;场:
        </td>
        <td style="border-bottom:1px solid;" colspan="2">
          第&nbsp;&nbsp;${roomNum}&nbsp;&nbsp;考场&nbsp;&nbsp;&nbsp;&nbsp;座位号:&nbsp;&nbsp;${setNum}
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
    <table style="width: 100%" border="1" cellspacing="0">
      <tr>
        <td>考生须知</td>
        <td>
          1. 考生只准携带必要的文具入场,如铅笔(涂黑答题卡用)、签字笔、橡皮。禁止携带任何书籍、笔记、资料、报刊、草稿纸以及各种无线通信工具（如移动电话）、录放音机、电子记事本等物品。如发现考生携带以上禁带物品，考生将作为违纪处理，取消该次考试成绩。考场内不得擅自相互借用文具。
          <br> 2. 提前半小时入场。请考生入场后按号入座，将本人《准考证》、有效身份证件（居民身份证，军人、武警人员证件，护照等）放在课桌上，以便核验。
          <br> 3. 考生答题前应认真填写答题卡中的姓名、准考证号等栏目。凡答题卡中该栏目漏填涂、错填涂或字迹不清、无法辨认的，答题卡一律无效。责任由考生自负。
          <br> 4. 开考后，考生不得中途退场。如因身体不适要求中途退场，须征得监考人员及考点主考批准，并在退场前将试卷、答题卡如数上交。
          <br> ........
        </td>
      </tr>
    </table>
  </div>

</body>

</html>