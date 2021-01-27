package com.liu.sourceProject.jvm.byteCode.parser;
/**
 * class 文件的结构
 * U4           magic (魔术)
 * U2           minor Version (副版本号)
 * U2           major version (主版本号)
 * U2           constant pool count (常量池中的个数)
 * cp_info      constant pool[常量池中的个数 - 1]  (常量池数组)
 * U2           Access Flag (访问标志，如public)
 * U2           this class(类索引，在常量池表中的索引)
 * U2           super class(父类索引，在常量池表中的索引)
 * U2           Interfaces Count (接口总数)
 * U2           Integerfaces[接口总数]
 * U2           field Count 字段总数
 * field_info   Field[字段总数]
 * U2           Method Count 方法总数
 * method_info  Methods[方法总数]
 * U2           attribute count 属性总数
 *attribute_info Atributes[属性总数]
 */