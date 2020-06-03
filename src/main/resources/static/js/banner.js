function imageAutoChange() {
    /*获取图片和索引的数组对象*/
    var $imgs = $("#notifycontainer li");
    var $nums = $("#indexcontainer li");

    var isStop = false;
    var index = 0;

    $nums.eq(index).addClass("numsover").siblings().removeClass("numsover");
    $imgs.eq(index).show();

    /*鼠标悬停在数字上的事件处理*/
    $nums.mouseover(function() {
        isStop = true;
        /*先把数字的背景改了*/
        $(this).addClass("numsover").siblings().removeClass("numsover");

        /*图片的索引和数字的索引是对应的，所以获取当前的数字的索引就可以获得图片，从而对图片进行操作处理*/
        index = $nums.index(this);
        $imgs.eq(index).show("slow");
        $imgs.eq(index).siblings().hide("slow");
    }).mouseout(function() {
        isStop = false
    });
    $("#bannerleftbtn").click(function () {
        if(index == 0) index = 5
        index--;
        $nums.eq(index).addClass("numsover").siblings().removeClass("numsover");
        $imgs.eq(index).show("slow").siblings().hide("slow");
    })
    $("#bannerrightbtn").click(function () {
        if(index >= 5) index = -1
        index++;
        $nums.eq(index).addClass("numsover").siblings().removeClass("numsover");
        $imgs.eq(index).show("slow").siblings().hide("slow");
    })
    /*设置循环*/
    setInterval(function() {
        if(isStop) return;
        if(index >= 5) index = -1;
        index++;

        $nums.eq(index).addClass("numsover").siblings().removeClass("numsover");
        $imgs.eq(index).show("slow").siblings().hide("slow");

    }, 5000);
}