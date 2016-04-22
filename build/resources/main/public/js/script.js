
$(function(){

  $("#mybutton").click(function(){
    $("#myform")[0].reset();
    $("#mybutton").fadeOut("slow");
    $("#myform").fadeIn("slow");
  });
  $("#mybutton3").click(function(){
     window.history.back();
  });
  $("#mybutton4").click(function(){
      window.location.href = "/";
  });
});
