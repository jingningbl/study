from flask import Flask, render_template, url_for
import pymysql
import json
# 生成Flask实例
app = Flask(__name__)


@app.route("/")
def hello():
    return render_template('my_template.html')

# /test路由    接收前端的Ajax请求


@app.route('/test', methods=['POST', 'GET'])
def my_echart():
    # 连接数据库
    conn = pymysql.connect(host='127.0.0.1', user='root',
                           password='1513', db='echarts')
    cur = conn.cursor()
    sql = 'SELECT t.hour,t.pvs from dw_pvs_everyhour_oneday t'
    cur.execute(sql)
    u = cur.fetchall()

    # 转换成json格式
    jsonData = {}
    xhour = []
    ypvs = []

    for data in u:
        xhour.append(data[0])
        ypvs.append(data[1])
    print(xhour)
    print(ypvs)

    jsonData['xdays'] = xhour
    jsonData['yvalues'] = ypvs
    # json.dumps()用于将dict类型的数据转换成str,因为如果直接将dict类型的数据写入json会报错，因此将数据写入时需要用到此函数
    j = json.dumps(jsonData)
    cur.close()
    conn.close()

    # 在浏览器上渲染my_template.html模板（为了查看输出数据)
    return (j)


if __name__ == '__main__':
    app.run(debug=True)
