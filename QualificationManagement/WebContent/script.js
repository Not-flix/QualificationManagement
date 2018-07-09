
function functionName()
{
	var select1 = document.forms.formName.selectName1; //変数select1を宣言
	var select2 = document.forms.formName.selectName2; //変数select2を宣言

	select2.options.length = 0;

	if (select1.options[select1.selectedIndex].value == "資格名")
	{
		select2.options[0] = new Option("基本情報技術者");
		select2.options[1] = new Option("応用情報技術者");
		select2.options[2] = new Option("データベーススペシャリスト");
	}

	else if (select1.options[select1.selectedIndex].value == "分類")
	{
		select2.options[0] = new Option("IT");
		select2.options[1] = new Option("会計");
		select2.options[2] = new Option("機会");
		select2.options[3] = new Option("料理");
	}

	else if (select1.options[select1.selectedIndex].value == "団体")
	{
		select2.options[0] = new Option("経済産業省");
		select2.options[1] = new Option("サーティファイ");
	}
}
