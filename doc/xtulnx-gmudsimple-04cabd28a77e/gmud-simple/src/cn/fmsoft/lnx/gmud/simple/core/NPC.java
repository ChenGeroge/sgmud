package cn.fmsoft.lnx.gmud.simple.core;

public class NPC {
	static int NPC_attrib[][] = new int [180][18];

	// [180]
	static final String NPC_names[] = new String[] {
	"阿庆嫂"  , "小顽童"  , "捕快"    , "采花大盗", "厨师"    , "村长"    , "独行大侠", "独脚大盗", "卖花妞"  , "中年妇人", 
	"葛朗台"  , "小女孩"  , "公子哥"  , "石料管事", "工地管事", "官兵"    , "游客"    , "黑衣大盗", "何铁手"  , "荷西", 
	"流氓"    , "流氓头"  , "茅十七"  , "民团教头", "老婆婆"  , "平一指"  , "小商贩"  , "小书童"  , "小裁缝"  , "老裁缝", 
	"顾炎武"  , "挑夫"    , "民团团丁", "张屠夫"  , "店小二"  , "寻捕"    , "盐商"    , "杂货贩"  , "商宝震"  , "武师教头", 
	"马春花"  , "护院武师", "王剑杰"  , "商剑鸣"  , "王剑英"  , "商老太"  , "平阿四"  , "王维扬"  , "马行空"  , "徐铮", 
	"阎基"    , "庄丁"    , "茶花女"  , "公孙大娘", "红拂女"  , "绿珠"    , "平婆婆"  , "桑轻虹"  , "李青照"  , "入画", 
	"瑞婆婆"  , "柳如是"  , "李师师"  , "侍书"    , "司棋"    , "听琴"    , "唐晚词"  , "小红"    , "薛涛"    , "聂隐娘", 
	"白衣教众", "玉璁儿"  , "褚红灯"  , "方长老"  , "韩长老"  , "黑衣教众", "红衣教众", "蓝衣教众", "齐林天"  , "唐思儿", 
	"余鸿儒"  , "十兵卫"  , "大熊"    , "未知火舞", "浪人甲"  , "浪人乙"  , "大口木子", "花十郎"  , "孙悟菜"  , "食野太郎", 
	"腾王丸"  , "天津虾"  , "野比"    , "枳右京"  , "和仲阳"  , "采药道人", "苍月道长", "古松道长", "谷虚道长", "明月", 
	"清风"    , "清虚道长", "烧饭道童", "桃花"    , "土匪"    , "土匪头领", "进香客"  , "迎客道童", "知客道长", "阿绣", 
	"白瑞德"  , "张福来"  , "欧阳千善", "马千刚"  , "赵千猛"  , "薛千柔"  , "史婆婆"  , "花万红"  , "封万剑"  , "王万轫", 
	"齐万翼"  , "柯万锺"  , "雪山教头", "雪豹"    , "艾里克"  , "巴巴雷恩", "北海鳄神", "华佗"    , "李猎户"  , "娜可露露", 
	"索莱斯"  , "人猿泰山", "王猎户"  , "张猎户"  , "赵猎户"  , "葛洪"    , "华岳"    , "空虚"    , "留孙真人", "茅衰", 
	"茅固"    , "茅盈"    , "小明月"  , "小清风"  , "张伯雨"  , "干匠"    , "墨邪"    , "山大王"  , "青龙坛主", "总瓢把子", 
	"朱雀坛主", "玄武坛主", "天微坛主", "紫煞坛主", "山岚坛主", "地罡坛主", "月下老人", "老管家"  , "地罡喽啰", "朱雀喽啰", 
	"朱雀喽啰", "山岚喽啰", "山岚喽啰", "山岚喽啰", "玄武喽啰", "玄武喽啰", "玄武喽啰", "紫煞喽啰", "紫煞喽啰", "紫煞喽啰", 
	"紫煞喽啰", "天微喽啰", "天微喽啰", "天微喽啰", "天微喽啰", "暗黑喽啰", "暗黑喽啰", "暗黑喽啰", "暗黑喽啰", "恶人 "
	};

	// [180]
	static final int NPC_desc[] = new int[] {0, 96, 149, 219, 297, 325, 369, 508, 629, 690, 
	852, 952, 1005, 1073, 1225, 1330, 1373, 1451, 1575, 1749, 
	1943, 2002, 2067, 2178, 2231, 2312, 2476, 2557, 2638, 2679, 
	2735, 2887, 2973, 3036, 3095, 3178, 3308, 3416, 3463, 3531, 
	3667, 3798, 3867, 3971, 4143, 4262, 4374, 4489, 4661, 4777, 
	4907, 5045, 5138, 5209, 5410, 5585, 5770, 5939, 6059, 6279, 
	6400, 6546, 6681, 6818, 6899, 6961, 7023, 7119, 7236, 7364, 
	7511, 7583, 7676, 7748, 7874, 7943, 8015, 8087, 8159, 8239, 
	8280, 8513, 8667, 8767, 8909, 8987, 9070, 9221, 9330, 9532, 
	9665, 9801, 9945, 10020, 10239, 10418, 10538, 10766, 10994, 11022, 
	11081, 11124, 11264, 11308, 11336, 11414, 11533, 11558, 11617, 11704, 
	11729, 11891, 11941, 12126, 12209, 12320, 12345, 12453, 12491, 12623, 
	12694, 12766, 12955, 13107, 13157, 13372, 13576, 13742, 13988, 14025, 
	14179, 14379, 14601, 14638, 14675, 14712, 14841, 14872, 14903, 14959, 
	15114, 15417, 15549, 15574, 15599, 15747, 15794, 15829, 15930, 15952, 
	15986, 16008, 16030, 16052, 16074, 16096, 16118, 16292, 16452, 16489, 
	16526, 16563, 16600, 16637, 16674, 16711, 16748, 16785, 16822, 16859, 
	16896, 16933, 16970, 17007, 17044, 17081, 17118, 17155, 17192, 17229 };

	// [181]
	static final int NPC_skill_index[] = new int[] {
	0, 44, 56, 92, 128, 164, 192, 276, 312, 348, 
	384, 428, 440, 476, 512, 548, 592, 612, 664, 740, 
	768, 804, 840, 884, 928, 964, 1000, 1036, 1048, 1060, 
	1096, 1116, 1144, 1180, 1216, 1228, 1264, 1284, 1320, 1412, 
	1464, 1500, 1536, 1604, 1696, 1764, 1848, 1876, 1976, 2028, 
	2080, 2140, 2176, 2236, 2320, 2388, 2456, 2532, 2624, 2732, 
	2800, 2860, 2944, 2996, 3064, 3100, 3136, 3236, 3272, 3340, 
	3408, 3476, 3544, 3628, 3728, 3796, 3864, 3932, 4000, 4068, 
	4136, 4236, 4304, 4356, 4424, 4460, 4496, 4548, 4640, 4708, 
	4760, 4852, 4920, 4964, 5032, 5124, 5208, 5292, 5360, 5428, 
	5496, 5580, 5688, 5716, 5744, 5780, 5832, 5884, 5952, 6036, 
	6120, 6212, 6248, 6332, 6416, 6500, 6576, 6660, 6712, 6796, 
	6880, 6964, 7032, 7108, 7144, 7252, 7360, 7452, 7528, 7636, 
	7744, 7852, 7960, 8068, 8176, 8284, 8400, 8468, 8536, 8652, 
	8720, 8788, 8904, 8972, 9040, 9108, 9176, 9244, 9344, 9436, 
	9544, 9644, 9736, 9844, 9936, 10044, 10112, 10156, 10256, 10324, 
	10424, 10524, 10632, 10740, 10848, 10940, 11032, 11124, 11216, 11308, 
	11400, 11492, 11600, 11708, 11816, 11924, 12032, 12140, 12248, 12356, 
	12492
	};

	// [180][5]
	static final int NPC_item[][] = new int[][] {
		{0, 45, 47, 0, 0},
		{0, 42, 0, 0, 0},
		{17, 42, 0, 0, 0},
		{0, 53, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{17, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{20, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{21, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{14, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{11, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{0, 39, 0, 0, 0},
		{15, 42, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{11, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{0, 42, 72, 0, 0},
		{0, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{16, 75, 42, 0, 0},
		{0, 0, 0, 0, 0},
		{17, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{11, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{11, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{24, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{11, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{11, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{11, 42, 0, 0, 0},
		{23, 42, 69, 0, 0},
		{0, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{11, 42, 0, 0, 0},
		{28, 42, 10, 0, 0},
		{0, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{22, 52, 51, 0, 0},
		{25, 52, 0, 0, 0},
		{0, 50, 51, 0, 0},
		{0, 42, 0, 0, 0},
		{26, 42, 49, 0, 0},
		{27, 42, 49, 0, 0},
		{0, 50, 51, 0, 0},
		{0, 50, 0, 0, 0},
		{0, 50, 0, 0, 0},
		{11, 50, 51, 0, 0},
		{0, 29, 42, 0, 0},
		{0, 42, 0, 0, 0},
		{11, 55, 0, 0, 0},
		{32, 0, 0, 0, 0},
		{21, 0, 0, 0, 0},
		{21, 60, 0, 0, 0},
		{21, 60, 0, 0, 0},
		{0, 60, 0, 0, 0},
		{34, 0, 0, 0, 0},
		{34, 0, 0, 0, 0},
		{34, 0, 0, 0, 0},
		{0, 60, 0, 0, 0},
		{21, 54, 0, 0, 0},
		{32, 42, 0, 0, 0},
		{11, 42, 56, 0, 0},
		{0, 42, 0, 0, 0},
		{30, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{11, 42, 0, 0, 0},
		{31, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{0, 58, 57, 0, 0},
		{0, 42, 0, 0, 0},
		{11, 42, 0, 0, 0},
		{11, 42, 0, 0, 0},
		{35, 60, 0, 0, 0},
		{0, 59, 0, 0, 0},
		{0, 59, 0, 0, 0},
		{33, 63, 0, 0, 0},
		{0, 60, 0, 0, 0},
		{35, 60, 0, 0, 0},
		{17, 59, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 60, 0, 0, 0},
		{35, 0, 0, 0, 0},
		{35, 62, 0, 0, 0},
		{0, 61, 0, 0, 0},
		{0, 60, 0, 0, 0},
		{35, 60, 0, 0, 0},
		{36, 42, 0, 0, 0},
		{0, 60, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{38, 65, 0, 0, 0},
		{38, 65, 0, 0, 0},
		{0, 65, 0, 0, 0},
		{38, 54, 0, 0, 0},
		{37, 64, 0, 0, 0},
		{0, 65, 0, 0, 0},
		{38, 65, 0, 0, 0},
		{38, 66, 0, 0, 0},
		{38, 65, 0, 0, 0},
		{0, 66, 0, 0, 0},
		{38, 65, 0, 0, 0},
		{0, 67, 0, 0, 0},
		{0, 67, 0, 0, 0},
		{0, 67, 0, 0, 0},
		{11, 67, 88, 91, 0},
		{0, 42, 0, 0, 0},
		{0, 67, 0, 0, 0},
		{0, 62, 64, 0, 0},
		{0, 56, 0, 0, 0},
		{0, 67, 44, 0, 0},
		{0, 67, 0, 0, 0},
		{0, 67, 0, 0, 0},
		{0, 67, 0, 0, 0},
		{0, 0, 59, 0, 0},
		{0, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{0, 59, 90, 0, 0},
		{0, 59, 0, 0, 0},
		{0, 59, 75, 0, 0},
		{0, 59, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{0, 42, 0, 0, 0},
		{0, 59, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{11, 0, 0, 0, 0},
		{11, 80, 0, 0, 0},
		{25, 52, 0, 0, 0},
		{32, 42, 82, 0, 0},
		{11, 42, 84, 0, 0},
		{37, 59, 86, 0, 0},
		{0, 60, 85, 0, 0},
		{0, 62, 64, 83, 0},
		{0, 59, 81, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 59, 0, 0, 0},
		{32, 42, 0, 0, 0},
		{32, 42, 0, 0, 0},
		{0, 62, 64, 0, 0},
		{0, 62, 64, 0, 0},
		{0, 62, 64, 0, 0},
		{11, 42, 0, 0, 0},
		{11, 42, 0, 0, 0},
		{11, 42, 0, 0, 0},
		{0, 60, 0, 0, 0},
		{0, 60, 0, 0, 0},
		{0, 60, 0, 0, 0},
		{0, 60, 0, 0, 0},
		{17, 59, 0, 0, 0},
		{17, 59, 0, 0, 0},
		{17, 59, 0, 0, 0},
		{17, 59, 0, 0, 0},
		{25, 52, 0, 0, 0},
		{25, 52, 0, 0, 0},
		{25, 52, 0, 0, 0},
		{25, 52, 0, 0, 0},
		{0, 0, 0, 0, 0}
	};

	// [180][8] 
	static final int NPC_sell_list[][] = new int[][] {
			{
			2, 7, 4, 0
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			3, 48, 46, 41, 0
		}, {
			255
		}, {
			0, 0   //葛朗台 sale item
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			6, 22, 17, 13, 21, 11, 44, 0
		}, {
			2, 73, 76, 0
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			2, 8, 9, 0
		}, {
			1, 6, 0
		}, {
			255
		}, {
			1, 42, 0
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			1, 5, 0
		}, {
			2, 2, 1, 0
		}, {
			255
		}, {
			255
		}, {
			2, 19, 18, 0
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			1, 49, 0
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			1, 3, 0
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}, {
			255
		}
	};

	static class NPCSKILLINFO {
		int data[];
		int size;
	}

	
	static int CopyItemList(int id)
	{
		int j1;
		if ((j1 = NPC.NPC_sell_list[id][0]) == 255 || j1 <= 0)
			return 0;
		int k1 = 0;
		for (int l1 = 0; l1 < j1; l1++)
		{
			GmudTemp.temp_array_32_2[k1][0] = (byte) NPC.NPC_sell_list[id][1 + l1];
			GmudTemp.temp_array_32_2[k1++][1] = 0;
		}

		return j1;
	}
	
	static void InitData()
	{
//		memcpy(NPC_attrib, NPCINFO::NPC_attribute, 180*18*sizeof(int));
		
//		System.arraycopy(NPCINFO.NPC_attribute, 0, NPC_attrib, 0, NPC_attrib.length);
		for (int i = 0; i < 180; i++) {
			for (int j = 0; j < 18; j++) {
				NPC_attrib[i][j] = NPCINFO.NPC_attribute[i][j];
			}
		}
	}
	static void ResetData(int i)
	{
		for (int j = 0; j < 18; j++)
			NPC_attrib[i][j] = NPCINFO.NPC_attribute[i][j];

		for (int k = 0; k < 5; k++)
			NPC_item[i][k] = NPCINFO.NPC_item[i][k];
	}

	static String GetNPCDesc(int id)
	{
		if(id < 0 || id > 178)
		{
//			wstring str("");
//			return str;
			return "";
		}
//		return gmud_readtext(1,NPC_desc[id],NPC_desc[1+id]);
		return Res.readtext(1,NPC_desc[id],NPC_desc[1+id]);
	}

	static void GetNPCSkill(NPCSKILLINFO value, int id)
	{
		value.data = null;
		value.size = 0;
		int i1 = NPC_skill_index[id];
		int i2 = NPC_skill_index[1 + id];
//		value->data = gmud_getarraydata(2, i1, i2);
//		value->size = (i1 - i2)/sizeof(int);
		
		byte[] data = Res.getarraydata(2, i1, i2);
		
		value.data = Res.convert(data, 0, data.length);
		value.size = value.data.length;
	}

	static int GetNPCSkillLevel(int NPCid, int skillID)
	{
		if (NPCid < 0 || NPCid > 179)
			return 0;
		int k;
		NPCSKILLINFO nsk = new NPCSKILLINFO();
		GetNPCSkill(nsk, NPCid);
		if ((k = nsk.data[0]) <= 0)
		{
//			delete[] nsk.data;
			return 0;
		}
			
		for (int l = 0; l < k; l++)
		{
			if (skillID == nsk.data[1 + l * 2])
			{
				int level = nsk.data[ 1 + l * 2 + 1];
//				delete[] nsk.data;
				return level;
			}
		}
//		delete[] nsk.data;
		return 0;
	}

	static int CopyNCPSkillList(int id)
	{
		int j;
		NPCSKILLINFO nsk = new NPCSKILLINFO();
		GetNPCSkill(nsk, id);
		if ((j = nsk.data[0]) <= 0)
			return 0;
		int k = 0;
		for (int l = 0; l < j; l++)
		{
			GmudTemp.temp_array_20_2[k][0] = nsk.data[1 + l * 2];
			GmudTemp.temp_array_20_2[k++][1] = nsk.data[1 + l * 2 + 1];
		}
//		free(nsk.data);
		return j;
	}
}
