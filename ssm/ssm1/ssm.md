**SSM整合项目**


**简介**：

**HOST**:localhost:8080


**联系人**:


**Version**:v1.0

**接口路径**：/v2/api-docs


# 课程模块

## 根据id查询课程信息


**接口描述**:


**接口地址**:`/student/selectOne`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
| age      | 年龄     | query | false    | integer  |        |
| classId  | 班级id   | query | false    | integer  |        |
| id       | 主键id   | query | true     | integer  |        |
| name     | 姓名     | query | false    | string   |        |

**响应示例**:

```json
{
	"age": 0,
	"classId": 0,
	"id": 0,
	"name": ""
}
```

**响应参数**:


| 参数名称 | 参数说明 | 类型           | schema         |
| -------- | -------- | -------------- | -------------- |
| age      |          | integer(int32) | integer(int32) |
| classId  |          | integer(int32) | integer(int32) |
| id       |          | integer(int32) | integer(int32) |
| name     |          | string         |                |





**响应状态**:


| 状态码 | 说明         | schema  |
| ------ | ------------ | ------- |
| 200    | OK           | Student |
| 401    | Unauthorized |         |
| 403    | Forbidden    |         |
| 404    | Not Found    |         |
## 测试接口


**接口描述**:


**接口地址**:`/student/test`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"age": 17,
	"classId": 1,
	"id": 2,
	"name": "小刘"
}
```


**请求参数**：

| 参数名称   | 参数说明     | in   | 是否必须 | 数据类型   | schema     |
| ---------- | ------------ | ---- | -------- | ---------- | ---------- |
| studentDto | 课程传输对象 | body | true     | StudentDto | StudentDto |

**schema属性说明**



**StudentDto**

| 参数名称 | 参数说明 | in   | 是否必须 | 数据类型       | schema |
| -------- | -------- | ---- | -------- | -------------- | ------ |
| age      | 年龄     | body | false    | integer(int32) |        |
| classId  | 班级id   | body | false    | integer(int32) |        |
| id       | 主键id   | body | true     | integer(int32) |        |
| name     | 姓名     | body | false    | string         |        |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           |        |
| 201    | Created      |        |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |