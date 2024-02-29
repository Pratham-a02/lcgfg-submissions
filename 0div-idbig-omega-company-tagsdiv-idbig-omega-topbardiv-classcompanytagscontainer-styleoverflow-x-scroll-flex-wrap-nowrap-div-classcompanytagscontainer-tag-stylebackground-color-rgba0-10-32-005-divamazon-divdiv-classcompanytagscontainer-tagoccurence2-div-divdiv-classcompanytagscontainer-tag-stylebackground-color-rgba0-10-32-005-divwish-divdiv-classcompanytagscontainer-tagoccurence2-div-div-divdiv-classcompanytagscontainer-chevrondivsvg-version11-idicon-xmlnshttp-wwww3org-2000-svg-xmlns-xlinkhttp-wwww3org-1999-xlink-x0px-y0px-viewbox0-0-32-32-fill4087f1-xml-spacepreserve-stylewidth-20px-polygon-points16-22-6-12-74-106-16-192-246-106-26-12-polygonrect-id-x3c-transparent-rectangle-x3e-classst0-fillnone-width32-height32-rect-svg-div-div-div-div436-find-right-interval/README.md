<h2><a href="https://leetcode.com/problems/find-right-interval/"><div id="big-omega-company-tags"><div id="big-omega-topbar"><div class="companyTagsContainer" style="overflow-x: scroll; flex-wrap: nowrap;"><div class="companyTagsContainer--tag" style="background-color: rgba(0, 10, 32, 0.05);"><div>Amazon</div><div class="companyTagsContainer--tagOccurence">2</div></div><div class="companyTagsContainer--tag" style="background-color: rgba(0, 10, 32, 0.05);"><div>Wish</div><div class="companyTagsContainer--tagOccurence">2</div></div></div><div class="companyTagsContainer--chevron"><div><svg version="1.1" id="icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 32 32" fill="#4087F1" xml:space="preserve" style="width: 20px;"><polygon points="16,22 6,12 7.4,10.6 16,19.2 24.6,10.6 26,12 "></polygon><rect id="_x3C_Transparent_Rectangle_x3E_" class="st0" fill="none" width="32" height="32"></rect></svg></div></div></div></div>436. Find Right Interval</a></h2><h3>Medium</h3><hr><div><p>You are given an array of <code>intervals</code>, where <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code> and each <code>start<sub>i</sub></code> is <strong>unique</strong>.</p>

<p>The <strong>right interval</strong> for an interval <code>i</code> is an interval <code>j</code> such that <code>start<sub>j</sub> &gt;= end<sub>i</sub></code> and <code>start<sub>j</sub></code> is <strong>minimized</strong>. Note that <code>i</code> may equal <code>j</code>.</p>

<p>Return <em>an array of <strong>right interval</strong> indices for each interval <code>i</code></em>. If no <strong>right interval</strong> exists for interval <code>i</code>, then put <code>-1</code> at index <code>i</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> intervals = [[1,2]]
<strong>Output:</strong> [-1]
<strong>Explanation:</strong> There is only one interval in the collection, so it outputs -1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> intervals = [[3,4],[2,3],[1,2]]
<strong>Output:</strong> [-1,0,1]
<strong>Explanation:</strong> There is no right interval for [3,4].
The right interval for [2,3] is [3,4] since start<sub>0</sub> = 3 is the smallest start that is &gt;= end<sub>1</sub> = 3.
The right interval for [1,2] is [2,3] since start<sub>1</sub> = 2 is the smallest start that is &gt;= end<sub>2</sub> = 2.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> intervals = [[1,4],[2,3],[3,4]]
<strong>Output:</strong> [-1,2,-1]
<strong>Explanation:</strong> There is no right interval for [1,4] and [3,4].
The right interval for [2,3] is [3,4] since start<sub>2</sub> = 3 is the smallest start that is &gt;= end<sub>1</sub> = 3.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= intervals.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>intervals[i].length == 2</code></li>
	<li><code>-10<sup>6</sup> &lt;= start<sub>i</sub> &lt;= end<sub>i</sub> &lt;= 10<sup>6</sup></code></li>
	<li>The start point of each interval is <strong>unique</strong>.</li>
</ul>
</div>