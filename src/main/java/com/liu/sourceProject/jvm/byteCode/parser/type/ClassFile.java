package com.liu.sourceProject.jvm.byteCode.parser.type;

/**
 * @author liu
 * @Date 2021/1/27 15:47
 */
public class ClassFile {
	/**
	 * 魔数
	 */
	private U4 magic;
	/**
	 * 副版本号
	 */
	private U2 minorVersion;
	/**
	 * 主版本号
	 */
	private U2 majorVersion;
	private U2 constantPoolCount;
	private CpInfo[] constantPool;
	private U2 accessFlag;
	private U2 thisClass;
	private U2 superClass;
	private U2 interfaceCount;
	private U2[] interfaces;
	private U2 fieldCount;
	private FieldInfo[] fieldInfos;
	private U2 methodCount;
	private MethodInfo[] methodInfos;
	private U2 attributeCount;
	private AttributeInfo[] attributeInfos;

	public U2 getSuperClass() {
		return superClass;
	}

	public void setSuperClass(U2 superClass) {
		this.superClass = superClass;
	}

	public U2 getInterfaceCount() {
		return interfaceCount;
	}

	public void setInterfaceCount(U2 interfaceCount) {
		this.interfaceCount = interfaceCount;
	}

	public U2[] getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(U2[] interfaces) {
		this.interfaces = interfaces;
	}

	public U2 getFieldCount() {
		return fieldCount;
	}

	public void setFieldCount(U2 fieldCount) {
		this.fieldCount = fieldCount;
	}

	public FieldInfo[] getFieldInfos() {
		return fieldInfos;
	}

	public void setFieldInfos(FieldInfo[] fieldInfos) {
		this.fieldInfos = fieldInfos;
	}

	public U2 getMethodCount() {
		return methodCount;
	}

	public void setMethodCount(U2 methodCount) {
		this.methodCount = methodCount;
	}

	public MethodInfo[] getMethodInfos() {
		return methodInfos;
	}

	public void setMethodInfos(MethodInfo[] methodInfos) {
		this.methodInfos = methodInfos;
	}

	public U2 getAttributeCount() {
		return attributeCount;
	}

	public void setAttributeCount(U2 attributeCount) {
		this.attributeCount = attributeCount;
	}

	public AttributeInfo[] getAttributeInfos() {
		return attributeInfos;
	}

	public void setAttributeInfos(AttributeInfo[] attributeInfos) {
		this.attributeInfos = attributeInfos;
	}

	public U4 getMagic() {
		return magic;
	}

	public void setMagic(U4 magic) {
		this.magic = magic;
	}

	public U2 getMinorVersion() {
		return minorVersion;
	}

	public void setMinorVersion(U2 minorVersion) {
		this.minorVersion = minorVersion;
	}

	public U2 getMajorVersion() {
		return majorVersion;
	}

	public void setMajorVersion(U2 majorVersion) {
		this.majorVersion = majorVersion;
	}

	public U2 getConstantPoolCount() {
		return constantPoolCount;
	}

	public void setConstantPoolCount(U2 constantPoolCount) {
		this.constantPoolCount = constantPoolCount;
	}

	public CpInfo[] getConstantPool() {
		return constantPool;
	}

	public void setConstantPool(CpInfo[] constantPool) {
		this.constantPool = constantPool;
	}

	public U2 getAccessFlag() {
		return accessFlag;
	}

	public void setAccessFlag(U2 accessFlag) {
		this.accessFlag = accessFlag;
	}

	public U2 getThisClass() {
		return thisClass;
	}

	public void setThisClass(U2 thisClass) {
		this.thisClass = thisClass;
	}
}
