package design_model.responsibility;

public class HandlerImpl extends Handler{

	@Override
	protected void dealRequest() {
		
		if(getSuccessor()!=null){
			System.out.println("请求下一个");
			getSuccessor().dealRequest();
		}
		else
			System.out.println("请求在这里终止");
	}

}
