if (!window.Richfaces) {
window.Richfaces = {};
}

if (!Richfaces.donut) {
	Richfaces.donut = {};
}

Richfaces.donut.customDonut = function customDonut(id,value,mode,dependencyValue){
				if(dependencyValue !="NAN")
				{
					var colorvalue=Richfaces.donut.setColor(parseFloat(dependencyValue)-parseFloat(value),mode);
					console.log("id" + id);

					console.log(parseFloat(dependencyValue)-parseFloat(value));
				}
				else 
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

	if(mode === 'normal'){
		return '#019DC4';
	}
	if (value > 0 && value <= 20 && mode === 'colorAmountReverse') {
		return "#2EA00B";
	} else if (value > 0 && value <= 20 && mode === 'colorAmount') {
		return "#F7464A";
	} else if (value > 20 && value <= 50 && (mode === 'colorAmount' || mode === 'colorAmountReverse')) {
		return "#DDDD88";
	} else if ((value > 50 && value <= 100) && mode === 'colorAmount') {
		return "#2EA00B";
	} else if ((value > 50 && value <= 100) && mode === 'colorAmountReverse') {
		return "#F7464A";
	} else if ((value > -100 && value <= 9) && mode === 'hasDependency') {
		return "#2EA00B";
	} else if ((value > 9 && value <= 10) && mode === 'hasDependency') {
		return "#DDDD88";
	}else if ((value > 10 && value <= 100) && mode === 'hasDependency') {
		return "#F7464A";
	}
	else {
		return "#000000";
	}

}