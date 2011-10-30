package org.agosti.abl.server.task;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.labs.taskqueue.Queue;
import com.google.appengine.api.labs.taskqueue.QueueFactory;
import com.google.appengine.api.labs.taskqueue.TaskOptions;

public class KeepAliveTask extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String QUEUE_NAME = "keepAliveQueue";
	private static final String QUEUE_URL = "/queue/keepAliveQueue";
	private static final int NUMBER_OF_TASKS = 6;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getAndPost(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getAndPost(req, resp);
	}

	private void getAndPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Queue queue = QueueFactory.getQueue(QUEUE_NAME);
		for(int i = 0; i<NUMBER_OF_TASKS; i++) {
			queue.add(TaskOptions.Builder.url(QUEUE_URL));
		}
	}

}
