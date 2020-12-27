package devops;

def deploy() {
    println("发布成功")
    System.out.println("system 发布成功")
}

def testHttpRequest(param1) {
    def response = httpRequest "http://httpbin.org/response-headers?param1=${param1}"
    println('Status: '+response.status)
    println('Response: '+response.content)
}

