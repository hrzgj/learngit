function check() {
  var roomPrice=document.forms["form2"]["roomPrice"].value;
  var roomHigh=document.forms["form2"]["roomHigh"].value;
  var roomArea=document.forms["form2"]["roomArea"].value;
  if(roomHigh == "" ||roomPrice == "" ||roomArea == "" )
  {
        alert("填写不能为空");
        return false;
  }
  else if(roomPrice<=0)
  {
      alert("价格不能小于0");
      return false;
  }
  else if(roomArea<=0||roomArea>=1000)
  {
      alert("房间面积应在0到1000之间");
      return false;
  }
  else  if(roomHigh<0||roomHigh>50)
  {
      alert("房间楼数应在0到50之间");
      return false;
  }
  else if(roomPrice>0&&roomArea>0&&roomArea<=1000&&roomHigh>0&&roomHigh<50)
  {
      return true;
  }

}