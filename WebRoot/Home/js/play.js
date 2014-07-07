function play_next(){
	var list0 = $(".list-item-name a");
	var list = [];
	var cur = $("#cur-music-url").val();
	var cur = cur.split('url=')[1];
	var first = list0[0].href;
	var first_url = first;
	first = first.split('url=')[1];
	var last = list0[list0.length-1].href;
	last = last.split('url=')[1];
	for(var i = 0; i < list0.length; i+=1){
		var href = list0[i].href;
		href = href.split('url=')[1];
		console.log(href);
		if( href == cur ){
			if( href == last ){
				location.href = first_url;
			}else{
				location.href = list0[i+1].href;
			}
		}	
	}
}

function play_prev(){
	var list0 = $(".list-item-name a");
	var list = [];
	var cur = $("#cur-music-url").val();
	var cur = cur.split('url=')[1];
	var first = list0[0].href;
	var first_url = first;
	first = first.split('url=')[1];
	var last = list0[list0.length-1].href;
	var last_url = last;
	last = last.split('url=')[1];
	for(var i = 0; i < list0.length; i+=1){
		var href = list0[i].href;
		href = href.split('url=')[1];
		console.log(href);
		if( href == cur ){
			if( href == first ){
				location.href = last_url;
			}else{
				location.href = list0[i-1].href;
			}
		}	
	}
}
setMenu(3);
var lycmove=function(currenttime)
{
    var lrcBox = document.getElementById("lrc");
    var domList = lrcBox.getElementsByTagName("p");
    var m = parseInt($('#lrc').attr("marginTop")) || 0;
    var index;
    var s=0;
    for (var i = 0; i < domList.length; i++) {
        var dataTimeLine = parseInt(domList[i].attributes["data-timeLine"].nodeValue);
        if(dataTimeLine > 0 && dataTimeLine === parseInt(currenttime)){
            //��ǰ��ʵ��±�
            index = i;
            //��ǰ�±�ֵ���ϴμ�¼���±�ֵ��ͬ�Ź�����һ���±�ֵֻ����һ��
            if(s != i){
                //��¼�±�ֵ
                s = i;
            }
            for(var j=0;j<domList.length;j++){
                removeClass(domList[j],"color");
            }
           if(index >= 0){
                addClass(domList[index],"color");
            }
            if(index>=4)
            {
                m=(index-4)*30;
                lrcBox.style.marginTop = "-" + m + "px";
            }
            
        };
    }
}

function getTime( d )
{
	var t_m = parseInt( d / 60 );
	var t_s = parseInt( d % 60 );
	if (t_m < 10 ) t_m = '0' + t_m;
	if( t_s < 10 ) t_s = '0' + t_s;
	return t_m + ":" + t_s;
}
var au = $("#au")[0];

au.addEventListener('ended', play_next, false);
function play(){
	if( au.paused )
	{
		au.play();
	}
	updatePlayed();
}

function updatePlayed()
{
	if( au.paused )
	{
	return;
	}
	var t1, t2;
	if( isNaN( au.duration ) || au.duration == Infinity) 
	{
		t2 = 60 * 4;
	}
	else
	{
		t2 = au.duration;
	}
	t1 = au.currentTime;
	var width = $(".mbar").width();
	$("#played").html( getTime( t1 ));
	$("#progress").width(t1 / t2 * width);
	setTimeout( updatePlayed, 400  );
	lycmove(t1);
}

function regist(){
	$(".ply").click(function(){
		$(this).attr("class", "pas");
		play();
		regist();
	})
	
	$(".pas").click(function(){
		$(this).attr("class", "ply");
		$("#au")[0].pause();
		regist();
	})
}

function showDuration()
{
	var au = $("#au")[0];
	console.log(au.duration);
	if( isNaN(au.duration) ){
		setTimeout( showDuration, 200);
		return;
	}
	$("#duration").html(getTime(au.duration));
}

regist();
showDuration();
$(".ply").attr("class", "pas");
regist();
play();

var currenttime=0;
var audio = document.getElementById("au")[0];
var lrcArray=[];
var lrcTimeArray = [] ;
var lrcline=[];
var myhash=[];
var musicName ;
var singer;
var lrc= $("#lrc-hidden").html();
//console.log(lrc);
var find=function(){
    var rgexp=/\[(\d*)\:(\d*)[\.|\:](\d*)\]/g;
    for(var i=0;i<lrcline.length;i++)
	{if(rgexp.test(lrcline[i]))
	return i;
		}
}
    var lrcdivide=function(lrc){
        lrc=lrc.replace(/\[(\d*)\:(\d*)[\.|\:](\d*)\]\n/g,"");
        console.log(lrc);
        lrcline = lrc.split("\n");
        var last = lrcline.pop();
        if( last != "" ){
            lrcline.push(last);
        }
        //������
        //console.log(lrcline[0]);
        /*lrcline[0].replace(/\[\w\w\:(.*?)\]/g,function(){
                    musicName = arguments[1] || "����";
                });
        //����
         lrcline[1].replace(/\[\w\w\:(.*?)\]/g,function(){
                    singer = arguments[1] || "����";
                });*/
        //ֻ��ȡ��ʲ���
        var i=find();
        lrcline.splice(0,i);
        console.log(lrcline);
        //��ȡ��ʺ�ʱ��
        for (var i =0;i< lrcline.length;i++) {
            lrcArray[i]=lrcline[i].slice(lrcline[i].lastIndexOf("]")+1);
            lrcline[i].replace(/\[(\d*)\:(\d*)[\.|\:](\d*)\]/g,function(){
            var min = arguments[1] | 0//��
            sec = arguments[2] | 0 //��
            Msec=arguments[3] | 0//����
            realMin = min * 60 + sec; //����������
            lrcTimeArray.push(realMin);
            myhash[realMin]=lrcArray[i];
            });
        };
        }  
    var showlyc=function(){
            for(var i=0;i<lrcTimeArray.length;i++)
            {
                $("#lrc").append("<p class=\"lrc-line\" data-timeLine=\"" + lrcTimeArray[i] + "\">" +myhash[lrcTimeArray[i]] + "</p>");
            }
    }
    function mergeSort(A,first,last){  
  
    var tempA=new Array();  
      
        if(first<last){  
        var mid = (first + last)>>>1;//����λ��  
        mergeSort(A,first,mid,tempA);  
        mergeSort(A,mid+1,last,tempA);  
        merge(A,first,mid,last,tempA);  
        }
        return A  
    }

    var merge=function(A,first,mid,last,tempA){  
            var n1=first,n2=mid+1;  
            var m=mid,L=last;  
            var i=0;  
              
            while(n1<=m && n2<=L){  
                if(A[n1]<A[n2]){  
                    tempA[i]=A[n1];  
                    n1++;  
                    i++;  
                }else{  
                    tempA[i]=A[n2];  
                    n2++;  
                    i++;  
                }  
            }  
            while(n1<=m){  
                tempA[i]=A[n1];  
                n1++;  
                i++;  
            }  
            while(n2<=L){  
                tempA[i]=A[n2];  
                n2++;  
                i++;  
            }  
            for (n1 = 0; n1 < i; n1++)  
                A[first + n1] = tempA[n1];//����ʱ����copy��A��  
        }

//---------------------------------------------------�����Ԫ���Ƿ���ĳ���ض����࣬����У��򷵻�true��
function hasClass(element,className){
    var classNum = element.className.split(" "),
        result;
    for(var i=0;i<classNum.length;i++){
        if(classNum[i] === className){
            result = true;
            break;
        }else{
            result = false;
        }
    }
    return result;
}
//---------------------------------------------------��Ϊƥ���Ԫ�����ָ��������
function addClass(element,className){
    if(!hasClass(element,className)){
        element.className += " " + className;
    }
}

//---------------------------------------------------��Ϊƥ���Ԫ��ɾ��ָ��������
function removeClass(element,className){
    if(hasClass(element,className)){
        var classNum = element.className.split(" ");
        for(var i=0;i<classNum.length;i++){
            if(classNum[i] === className){
                classNum.splice(i,1);
                element.className = classNum.join(" ");
                break;
            }
        }
    }
}
lrcdivide(lrc);
//console.log(lrcArray);
console.log(myhash);
mergeSort(lrcTimeArray,0,lrcTimeArray.length-1);
//console.log(lrcTimeArray);
showlyc();
//lycmove(230);
//console.log(au.currentTime);

//---------------------------------------------------����Firefox֧��offsetX��offsetY��
//����������ڵ�һ����λ�ĸ�Ԫ�ص����
function coordinate(e){
var o = window.event || e,
coord,
coord_X,
coord_Y;

coord_X = (o.offsetX === undefined) ? getOffset(o).X : o.offsetX;
coord_Y = (o.offsetY === undefined) ? getOffset(o).Y : o.offsetY;
coord = { "coord_X" : coord_X , "coord_Y" : coord_Y };
return coord;
}
function getOffset(e){
var target = e.target, // ��ǰ������Ŀ�����
eventCoord,
pageCoord,
offsetCoord;

//���㵱ǰ����Ԫ�ص��ĵ��ľ���
pageCoord = getPageCoord(target);

//�����굽�ĵ��ľ���
eventCoord = {
X : window.pageXOffset + e.clientX,
Y : window.pageYOffset + e.clientY
};

//�����ȡ��굽��һ����λ�ĸ�Ԫ�ص����
offsetCoord = {
X : eventCoord.X - pageCoord.X,
Y : eventCoord.Y - pageCoord.Y
};
return offsetCoord;
}
function getPageCoord(element){
var coord = { X : 0, Y : 0 };
//����ӵ�ǰ����Ԫ�ص���ڵ�Ϊֹ��
//���� offsetParent Ԫ�ص� offsetLeft �� offsetTop ֵ֮��
while (element){
coord.X += element.offsetLeft;
coord.Y += element.offsetTop;
element = element.offsetParent;
}
return coord;
}
//---------------------------------------------------�����������İٷֱȡ�
function progressBarPercentage(totalLength,actLage){
//�����ܳ���totalLength�͵�ǰ��������actLage
var Result = (parseInt(actLage) / parseInt(totalLength)) * 100;
return Math.ceil(Result);
}

//---------------------------------------------------�������ȱ仯��̡�
function getSongProgress(event){
//var progressRateBg =$(".mbar"),
//var    mplayer = document.getElementById("au"),
var progressBP;
var SongProgress;

//��þ����Ԫ�ؾ���
var coord = coordinate(event),
  offsetCoord_X = coord.coord_X;
//���������Ŀ��
songScheduleChange(offsetCoord_X);
//���������Ŀ�ȱ���
progressBP = progressBarPercentage($("#mbar").width(),offsetCoord_X) / 100;
//��ʵ�ĸ�������ֵ
function left(){
		var left=progressBP*100;
		left=left+'%';
		return left;}
		$(".progress_icon").css("left",left());
SongProgress = progressBP * $("#au")[0].duration;
return SongProgress;
}

//---------------------------------------------------�����������仯��
function songScheduleChange(size){
var progress = document.getElementById("progress");
progress.style.width = size + "px";
}
var songProgressAdjust = function(time){
	//console.log(time);
	 au.currentTime=time;
	//console.log(au.currentTime);
	  //�������Ž�Ⱥ󣬸�ʵ�λ
	  //lrcAtuoMove(time);
	};
	$("#mbar").click(function(){
		 if($("#au").src!= ""){
			 //console.log(au.currentTime);
		     var activeProgress = getSongProgress(event);
		     //console.log(activeProgress);
		     songProgressAdjust(activeProgress);

		 }else{
		     return false;
		 }
		});
	function VolumeChange(size){
		var progress = document.getElementById("ui-slider-range");
		progress.style.width = size + "px";
		}
$("#volSlider").click(function()
	{
	//��þ����Ԫ�ؾ���
	var coord = coordinate(event),
	    offsetCoord_X = coord.coord_X;
    //console.log(offsetCoord_X);
	//���������Ŀ��
	VolumeChange(offsetCoord_X);
	var VolumeNow=progressBarPercentage($("#volSlider").width(),offsetCoord_X) / 100;
	au.volume = VolumeNow;
	
	});


