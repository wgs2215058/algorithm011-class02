学习笔记
本周学习了递归，分治和回溯
递归 注意的特点
递归-调用自己进行循环
特点：1.向下进入不同的递归层，向上又回到原来一层；2.参数来传递不同的变量；3.每一层都是一份拷贝，有参数带来变化
递归 java模板
public void recur(int level, int param) {
  //terminator 递归终止条件
  if(level>MAX_LEVEL){
    return；
  }
  // process current logic 递归处理逻辑 
  process(level, param); 
  // drill down //进入到下一层
  recur( level: level + 1, newParam); 
  // restore current status  清扫当层状态
  
}
备注： 递归终止条件一定要一开始就写出来，否则会成为

分治和回溯都是递归的一种衍生
