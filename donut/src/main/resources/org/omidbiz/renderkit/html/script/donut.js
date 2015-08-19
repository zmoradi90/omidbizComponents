if (!window.Richfaces) {
window.Richfaces = {};
}

if (!Richfaces.donut) {
	Richfaces.donut = {};
}

Richfaces.donut.customDonut = function customDonut(id,value,mode){
				var colorvalue=Richfaces.donut.setColor(value,mode);
				var doughnutData = [
								{
									value: value,
									color: colorvalue,
								},
								{
									value: Math.round(value-100),
									color: "#DDDDDD",
								}
								];
					var tempid="#"+id;
					var ctx =jQuery(tempid)[0].getContext("2d");
					window.myDoughnut = new Chart(ctx).Doughnut(doughnutData, {segmentShowStroke : false,responsive : false ,animation: false, showTooltips: false,});
				}

Richfaces.donut.setColor=function setColor(value, mode) {

	if (value > 0 && value <= 20 && mode === 'reverse') {
		return "#2EA00B";
	} else if (value > 0 && value <= 20 && mode === 'normal') {
		return "#F7464A";
	} else if (value > 20 && value <= 50) {
		console.log("hell");
		return "#DDDD88";
	} else if ((value > 50 && value <= 100) && mode === 'normal') {
		return "#2EA00B";
	} else if ((value > 50 && value <= 100) && mode === 'reverse') {
		return "#F7464A";
	} else {
		return "#000000";
	}

}