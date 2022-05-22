import json
from flask import Flask, jsonify
app = Flask(__name__)


@app.route('/')
def hello_world():
    return 'Hello, World!'


@app.route('/hello')
def hello():
    return 'Hello2'


# app.run(host, port, debug, options)
app.run("0.0.0.0", 5000, debug=True,)

app.config['JSON_AS_ASCII'] = False

# 随便定义个json字典
dic = {"a": 1, "b": 2, "c": "你好"}


@app.route('/jsonify')
def jsonifys():
    # Content-Type: application/json
    return jsonify(dic)


@app.route('/jsondumps')
def jsondumps():
    # Content-Type: text/html; charset=utf-8
    return json.dumps(dic, ensure_ascii=False)
