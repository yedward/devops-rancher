package devops;

def name = "zhangsan"
def age = 25

def deploy() {
    println("发布成功 ${name}")
    System.out.println("system 发布成功 ${age}")
}

def testHttpRequest(param1) {
    def response = httpRequest "http://httpbin.org/response-headers?param1=${param1}"
    println('Status: '+response.status)
    println('Response: '+response.content)
}

