# 企业进销存系统 SIMS(Sales Invoicing Management System)

# 功能测试用例集

# 草稿

## plsw软工二小组

## 2017-10-1

## 更新历史

| **修改人员** | **日期** | **变更原因** | **版本号** |
| --- | --- | --- | --- |
| 王灿灿 | 2017-10-2 | 整合文档 | V1.0 草稿 |


###**财务人员测试用例套件覆盖表**

|编号|测试用例套件1|测试用例套件2|测试用例套件3|
| --- | --- | --- | --- |
|BAM.Edit|TUS1|||
|BAM.Find|TUS1|||
|BAM.Select.Document|TUS1|||
|BAM.Cancel|TUS1|||
|BAM.Confirm|TUS1|||
|BAM.Check|TUS1|||
|BAM.New|TUS1|||
|BAM.Del|TUS1|||
|BAM.Modify|TUS1|||
|BAM.Close.Exit|TUS1|||
|BAM.ErrorPermission|TUS1|||
|BAM.ErrorName|TUS1|||
|BAM.Succeed|TUS1|||
|MFD.Close.Exit||TUS2||
|MFD.Confirm||TUS2||
|MFD.Cancel||TUS2||
|MFD.Select.Document||TUS2||
|MFD.Edit||TUS2||
|MFD.Print||TUS2||
|MFD.Select.DocumentType||TUS2||
|MFD.Select.DocumentState||TUS2||
|MFD.New||TUS2||
|MFD.Modify||TUS2||
|MFD.Del||TUS2||
|MFD.Check||TUS2||
|MFD.Sub||TUS2||
|MFD.Compelet||TUS2||
|MFD.Succeed||TUS2||
|SetUp.Close.Edit|||TUS3|
|SetUp.Edit|||TUS3|
|SetUp.Confirm |||TUS3|
|SetUp.Cancel|||TUS3|
|SetUp.Select.Books|||TUS3|
|SetUp.New|||TUS3|
|SetUp.Check|||TUS3|
|SetUp.Delete|||TUS3|
|SetUp.Succeed|||TUS3|
###**财务人员测试用例场景** 
 
**TUS1：账户管理**  

| ID | 输入 | 输入 |预期输出|
| --- | --- | --- | --- |
|| 操作| 输入信息 | 
| TUS1-1 | 勾选账户 | 无 | 系统将被勾选账户添加至待处理列表 |
| TUS1-2 | 增加账户 | 工商银行_2017102，confirm | 新增账户成功 |
| TUS1-3 | 增加账户 | 工商银行_2017102,confirm | 已存在该账户 |
| TUS1-4 | 增加账户 | 你猜哪家?_2017102,confirm | 非法银行名称，请重新输入|
| TUS1-5 | 删除账户 | 工商银行_2017102,confirm | 删除账户成功 | 
| TUS1-6 | 修改账户名称 | （原）工商银行_9999999,招商银行_6666666,confirm | 修改账户名成功 |
| TUS1-7 | 修改账户名称 | （原）招商银行_6666666,招商银行_6666666,confirm | 重复修改,请重新输入 |
| TUS1-8 | 查找账户 | 工商银行_201 | 工商银行_201XX,工商银行_201XX…… |
| TUS1-9 | 取消 | 无 | 系统取消当前正待完成的任务 |
 
<BR/>
**TUS2：制定财务类单据**  

| ID | 输入 | 输入 |预期输出|
| --- | --- | --- | --- |
|| 操作| 输入信息 |
| TUS2-1 | 勾选单据 | 无 | 系统将被勾选单据添加至待处理列表 |
| TUS2-2 | 增加单据 | SKD-20171001-99999 | 新增单据成功 |
| TUS2-3 | 增加单据 | SKD-20171001-99999 | 已存在该单据 |
| TUS2-4 | 增加单据 | LPL-20171001-V587,confirm | 非法单据名称，请重新输入|
| TUS2-5 | 删除单据 | SKD-20171001-99999,confirm | 删除成功 | 
| TUS2-6 | 修改单据 | （原）供货商：王大锤,供货商：王尼玛,confirm | 修改单据成功 |
| TUS2-7 | 修改单据 | （原）供货商：王大锤,供货商：王大锤,confirm | 重复修改,请重新输入 |
| TUS2-8 | 查找单据 | SKD-2017 | SKD-2017XX,SKD-2017XX…… |
| TUS2-9 | 提交单据 | 无 | 系统将单据提交至总经理|
| TUS2-10 | 取消 | 无 | 系统取消当前正待完成的任务 |


<BR/>
**TUS3：期初建账**  

| ID | 输入 | 输入 |预期输出|
| --- | --- | --- | --- |
|| 操作| 输入信息 |
| TUS3-1 | 勾选账簿 | 无 | 系统将被勾选账簿添加至待处理列表 |
| TUS3-2 | 增加账簿 | 账簿2017-2018 | 新增账簿成功 |
| TUS3-3 | 增加账户 | 账簿2017-2018 | 已存在该账簿 |
| TUS3-4 | 增加账户 | 小本本2037-2038 | 非法账簿名称，请重新输入|
| TUS3-5 | 删除账簿 | 账簿2017-2018 | 删除账簿户成功 |

###**总经理测试用例套件覆盖表**

| 编号 | 测试用例套件1 | 测试用例套件2 |
| --- | --- | --- |
| Catalog.Cancle | TUS1 |   |
| Catalog.New | TUS1 |   |
| Catalog.Del | TUS1 |   |
| Catalog.Confirm | TUS1 |   |
| Promotion.Select |   | TUS2 |
| Promotion.New |   | TUS2 |
| Promotion.Del. |   | TUS2 |
| Promotion.Edit |   | TUS2 |
| Promotion.Cancle |   | TUS2 |
| Promotion.Confirm |   | TUS2 |
| Promotion.Confirm.Invalid |   | TUS2 |
| Promotion.Confirm.Valid |   | TUS2 |
| Promotion.Valid |   | TUS2 |
| Promotion.Valid.StartDate |   | TUS2 |
| Promotion.Valid.EndDate |   | TUS2 |
| Promotion.Valid.GoodsGift |   | TUS2 |
| Promotion.Valid.GoodsDiscount |   | TUS2 |
| Promotion.Valid. AmountGift |   | TUS2 |
| Promotion.Valid. AmountDiscount |   | TUS2 |
| Promotion.Valid.Redundancy |   | TUS2 |
| Promotion.Update |   | TUS2 |
| Promotion.Update.GoodsGift |   | TUS2 |
| Promotion.Update.GoodsDiscount |   | TUS2 |
| Promotion.Update.AmountGift |   | TUS2 |
| Promotion.Update.AmountDiscount |   | TUS2 |
###**总经理测试用例场景**

**TUS1：审批单据**  

| ID | 输入 | 输入 |预期输出|
| --- | --- | --- | --- |
|| 操作| 输入信息 |
| TUS1-1 | 取消商品调整任务 |   | 已取消 |
| TUS1-2 | 输入商品标识 |   | 查找到该商品 |
| TUS1-3 | 删除商品 |   | 已移除 |
| TUS1-4 | 确认商品调整任务结束 |   | 已完成|
<BR/>

**TUS2：制定销售策略**  

| ID | 输入 | 输入 |预期输出|
| --- | --- | --- | --- |
|| 操作| 输入信息 |
| TUS2-1 | 制定类型 | 类型 | 显示该类型列表 |
| TUS2-2 | 增加策略 |   | New |
| TUS2-3 | 删除策略 |   | 已移除 |
| TUS2-4 | 编辑策略 |   | 允许编辑 |
| TUS2-5 | 取消 |   | 已取消 |
| TUS2-6 | 确认 |   | 结束 |
| TUS2-7 | 未通过检查 |   | 不正确 |
| TUS2-7 | 通过检查 |   | 正确并tuichu2 |

###**库存管理人员测试用例套件覆盖表**

| 编号 | 测试用例套件1 | 测试用例套件2 | 测试用例套件3 | 测试用例套件4 | 测试用例套件5 |
| --- | --- | --- | --- | --- | --- |
| Classify.New.Show | TUS1 |   |   |   |   |
| Classify.New.Exist | TUS1 |   |   |   |   |
| Classify.Del | TUS1 |   |   |   |   |
| Classify.Edit.Show | TUS1 |   |   |   |   |
| Classify.Edit.Name | TUS1 |   |   |   |   |
| Classify.Edit.Repeat | TUS1 |   |   |   |   |
| Classify.Invalid | TUS1 |   |   |   |   |
| Classify.Record | TUS1 |   |   |   |   |
| Classify.Confirm | TUS1 |   |   |   |   |
| Classify.Cancel | TUS1 |   |   |   |   |
| Classify.Close.Exit | TUS1 |   |   |   |   |
| Merchandise.Invalid |   | TUS2 |   |   |   |
| Merchandise.New.Show |   | TUS2 |   |   |   |
| Merchandise.New.Exist |   | TUS2 |   |   |   |
| Merchandise.Del |   | TUS2 |   |   |   |
| Merchandise.Edit.Show |   | TUS2 |   |   |   |
| Merchandise.Edit.Repeat |   | TUS2 |   |   |   |
| Merchandise.Edit.Others |   | TUS2 |   |   |   |
| Merchandise.Record |   | TUS2 |   |   |   |
| Merchandise.Confirm |   | TUS2 |   |   |   |
| Merchandise.Cancel |   | TUS2 |   |   |   |
| Merchandise.Close.Exit |   | TUS2 |   |   |   |
| Check.Invalid |   |   | TUS3 |   |   |
| Check.Record |   |   | TUS3 |   |   |
| Check.Close.Exit |   |   | TUS3 |   |   |
| Stocking.Excel |   |   |   | TUS4 |   |
| Stocking.Record |   |   |   | TUS4 |   |
| Stocking.Close.Exit |   |   |   | TUS4 |   |
| Documents.Warn |   | TUS2 |   |   | TUS5 |
| Documents.Remind |   |   |   |   | TUS5 |
| Documents.Invalid |   |   |   |   | TUS5 |
| Documents.Record |   |   |   |   | TUS5 |
| Documents.Confirm |   |   |   |   | TUS5 |
| Documents.Cancel |   |   |   |   | TUS5 |
| Documents.Close.Exit |   |   |   |   | TUS5 |
###**库存管理人员测试用例场景**

**TUS1：商品分类管理操作** 
 
| ID | 输入 | 输入 |预期输出|
| --- | --- | --- | --- |
|| 操作| 输入信息 |
| TUS1-1 | 增加分类 | 亮光类 | 已添加 |
| TUS1-2 | 增加分类 | 亮光类 | 已存在该分类 |
| TUS1-3 | 减去分类 | 亮光类 | 已移除 |
| TUS1-4 | 修改分类 | 较亮光类，暗光类 | 已修改 |
| TUS1-5 | 修改分类 | 暗光类，暗光类 | 重复修改 |
| TUS1-6 | 修改分类 | 红光类，蓝光类 | 不存在该分类|
| TUS1-7 | 增加分类 | u8914 | 错误格式 |
<BR/>

**TUS2：商品管理操作** 
 
| ID | 输入 | 输入 |预期输出|
| --- | --- | --- | --- |
|| 操作| 输入信息 |
| TUS2-1 | 增加商品 | 白炽灯 | 已添加 |
| TUS2-2 | 增加商品 | 白炽灯 | 已存在该商品 |
| TUS2-3 | 减去商品 | 白炽灯 | 已移除 |
| TUS2-4 | 修改商品 | 节能灯，LED灯 | 已修改 |
| TUS2-5 | 修改商品 | LED灯，LED灯 | 重复修改 |
| TUS2-6 | 修改商品 | 室外灯，室内灯 | 不存在该商品 |
| TUS2-7 | 修改商品 | LED灯 1个-&gt;5个 | 已修改，已提交库存报警单 |
| TUS2-7 | 增加商品 | u8914 | 错误格式 |
| TUS2-8 | 查询商品 | LED灯 | LED灯的商品信息 |
<BR/>

**TUS3：库存查看** 
 
| ID | 输入 | 输入 |预期输出|
| --- | --- | --- | --- |
|| 操作| 输入信息 |
| 操作 | 输入信息 |
| TUS3-1 | 库存查看 | 19:00-20:00 | 该时间段的库存交易信息 |
<BR/>

**TUS4：库存盘点** 
 
| ID | 输入 | 输入 |预期输出|
| --- | --- | --- | --- |
|| 操作| 输入信息 |
| TUS4-1 | 库存盘点 |   | 当天的库存交易信息 |
<BR/>

**TUS5：制定库存类单据** 
 
| ID | 输入 | 输入 |预期输出|
| --- | --- | --- | --- |
|| 操作| 输入信息 |
| TUS5-1 | 库存赠送单 | 白炽灯 5 | 已提交库存赠送单已提交库存报警单 |
| TUS5-2 | 库存报溢单 | 白炽灯 5 | 已提交库存报溢单 |
| TUS5-3 | 库存报损单 | 白炽灯 5 | 已提交库存报损单已提交库存报警单 |
<BR/>
###**进货销售人员测试用例套件覆盖表**

| 编号 | 测试用例套件1 | 测试用例套件2 | 测试用例套件3 | 测试用例套件4 |
| --- | --- | --- | --- | --- |
| Client.Input | TUS1 |   |   |   |
| Client.Cancel | TUS1 |   |   |   |
| Client.Modify | TUS1 |   |   |   |
| Client.Modify.Start | TUS1 |   |   |   |
| Client.Modify.Filter | TUS1 |   |   |   |
| Client.Modify.Select | TUS1 |   |   |   |
| Client.Modify.Edit | TUS1 |   |   |   |
| Client.Modify.Invalid | TUS1 |   |   |   |
| Client.Modify.Null | TUS1 |   |   |   |
| Client.Modify.End | TUS1 |   |   |   |
| Client.Filter | TUS1 |   |   |   |
| Client.Filter.ByID | TUS1 |   |   |   |
| Client.Filter.ByName | TUS1 |   |   |   |
| Purchase.Input |   | TUS2 |   |   |
| Purchase.Cancel |   | TUS2 |   |   |
| Purchase.Modify |   | TUS2 |   |   |
| Purchase.Select |   | TUS2 |   |   |
| Purchase.Select.Edit |   | TUS2 |   |   |
| Purchase.Input.Invalid |   | TUS2 |   |   |
| Purchase.Input.null |   | TUS2 |   |   |
| Purchase.Input.Blank |   | TUS2 |   |   |
| Purchase.Input.End |   | TUS2 |   |   |
| Purchase.ExamineAndApprove |   | TUS2 |   |   |
| Sale.Input |   |   |   | TUS4 |
| Sale.Cancel |   |   |   | TUS4 |
| Sale.Select |   |   |   | TUS4 |
| Sale.Select.Edit |   |   |   | TUS4 |
| Sale.Input.Invalid |   |   |   | TUS4 |
| Sale.Input.Blank |   |   |   | TUS4 |
| Sale.Input.End |   |   |   | TUS4 |
| Sale.ExamineAndApprove |   |   |   | TUS4 |
| PurchaseReturn.Input |   |   | TUS3 |   |
| PurchaseReturn.Cancel |   |   | TUS3 |   |
| PurchaseReturn.Modify |   |   | TUS3 |   |
| PurchaseReturn.Select |   |   | TUS3 |   |
| PurchaseReturn.Select.Edit |   |   | TUS3 |   |
| PurchaseReturn.Input.Invalid |   |   | TUS3 |   |
| PurchaseReturn.Input.Null |   |   | TUS3 |   |
| PurchaseReturn.Input.Blank |   |   | TUS3 |   |
| PurchaseReturn.Input.End |   |   | TUS3 |   |
| PurchaseReturn. .ExamineAndApprove |   |   | TUS3 |   |
###**进货销售人员测试用例场景**

**TUS1：管理客户** 
 
| ID | 输入 | 输入 |预期输出|
| --- | --- | --- | --- |
|| 操作| 输入信息 |
| TUS1-1 | 增加客户 | 天猫超市 | 已增加 |
| TUS1-2 | 增加分类 | 教育超市 | 已存在该用户 |
| TUS1-3 | 删除客户 | 朝花夕拾超市 | 已删除 |
| TUS1-4 | 删除客户 | 沃尔玛 | 已删除 |
| TUS1-5 | 修改客户 | 天猫超市 | 已修改 |
| TUS1-6 | 修改客户 | 京东商城 | 不存在该客户 |
| TUS1-7 | 查询客户 | 教育超市 | 不存在该客户 |
| TUS1-8 | 查询客户 | 京东商城 | 格式错误 |
<BR/>

**TUS2：制定进货单** 
 
| ID | 输入 | 输入 |预期输出|
| --- | --- | --- | --- |
|| 操作| 输入信息 |
| TUS2-1 | 选择商品 | 白炽灯 | 已添加 |
| TUS2-2 | 选择商品 | 白炽灯 | 已存在该商品 |
| TUS2-3 | 删除商品 | 白炽灯 | 已移除 |
| TUS2-4 | 删除商品 | 节能灯，LED灯 | 已移除 |
| TUS2-5 | 输入数量 | 节能灯：100 | 已输入 |
| TUS2-6 | 输入商品单价 | 白炽灯：20 | 已输入 |
| TUS2-7 | 修改商品数量 | LED灯 1个-&gt;5个 | 已修改 |
| TUS2-8 | 查询商品 | LED灯 | LED灯的商品信息(供应商、操作员) |
<BR/>

**TUS3：制定进货退货单** 
 
| ID | 输入 | 输入 |预期输出|
| --- | --- | --- | --- |
|| 操作| 输入信息 |
| TUS3-1 | 选择商品 | 白炽灯 | 已添加 |
| TUS3-2 | 选择商品 | 节能灯 | 已存在该商品 |
| TUS3-3 | 删除商品 | 白炽灯 | 已移除 |
| TUS3-4 | 删除商品 | 节能灯，LED灯 | 已移除 |
| TUS3-5 | 输入数量 | 节能灯：100 | 已输入 |
| TUS3-6 | 输入商品单价 | 白炽灯：20 | 已输入 |
| TUS3-7 | 修改商品数量 | LED灯 1个-&gt;5个 | 已修改 |
| TUS3-8 | 查询商品 | LED灯 | LED灯的商品信息(供应商、操作员) |
<BR/>

**TUS4：制定销售单** 
 
| ID | 输入 | 输入 |预期输出|
| --- | --- | --- | --- |
|| 操作| 输入信息 |
| TUS4-1 | 选择商品 | 白炽灯 | 已添加 |
| TUS4-2 | 选择商品 | 白炽灯 | 已存在该商品 |
| TUS4-3 | 删除商品 | 白炽灯 | 已移除 |
| TUS4-4 | 删除商品 | 节能灯，LED灯 | 已移除 |
| TUS4-5 | 输入数量 | 节能灯：100 | 已输入 |
| TUS4-6 | 输入商品单价 | 白炽灯：20 | 已输入 |
| TUS4-7 | 修改商品数量 | LED灯 1个-&gt;5个 | 已修改 |
| TUS4-8 | 查询商品 | LED灯 | LED灯的商品信息(供应商、操作员) |
<BR/>