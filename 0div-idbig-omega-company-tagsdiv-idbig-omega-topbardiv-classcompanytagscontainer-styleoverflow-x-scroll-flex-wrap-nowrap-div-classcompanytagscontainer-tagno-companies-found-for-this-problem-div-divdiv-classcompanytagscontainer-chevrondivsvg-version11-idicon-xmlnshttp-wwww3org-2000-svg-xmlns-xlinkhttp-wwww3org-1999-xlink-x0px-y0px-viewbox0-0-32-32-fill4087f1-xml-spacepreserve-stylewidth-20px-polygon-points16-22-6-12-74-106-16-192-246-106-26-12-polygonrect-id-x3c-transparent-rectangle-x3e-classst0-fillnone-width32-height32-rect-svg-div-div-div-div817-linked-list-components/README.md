<h2><a href="https://leetcode.com/problems/linked-list-components/"><div id="big-omega-company-tags"><div id="big-omega-topbar"><div class="companyTagsContainer" style="overflow-x: scroll; flex-wrap: nowrap;"><div class="companyTagsContainer--tag">No companies found for this problem</div></div><div class="companyTagsContainer--chevron"><div><svg version="1.1" id="icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 32 32" fill="#4087F1" xml:space="preserve" style="width: 20px;"><polygon points="16,22 6,12 7.4,10.6 16,19.2 24.6,10.6 26,12 "></polygon><rect id="_x3C_Transparent_Rectangle_x3E_" class="st0" fill="none" width="32" height="32"></rect></svg></div></div></div></div>817. Linked List Components</a></h2><h3>Medium</h3><hr><div><p>You are given the <code>head</code> of a linked list containing unique integer values and an integer array <code>nums</code> that is a subset of the linked list values.</p>

<p>Return <em>the number of connected components in </em><code>nums</code><em> where two values are connected if they appear <strong>consecutively</strong> in the linked list</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/22/lc-linkedlistcom1.jpg" style="width: 424px; height: 65px;">
<pre><strong>Input:</strong> head = [0,1,2,3], nums = [0,1,3]
<strong>Output:</strong> 2
<strong>Explanation:</strong> 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/22/lc-linkedlistcom2.jpg" style="width: 544px; height: 65px;">
<pre><strong>Input:</strong> head = [0,1,2,3,4], nums = [0,3,1,4]
<strong>Output:</strong> 2
<strong>Explanation:</strong> 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the linked list is <code>n</code>.</li>
	<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= Node.val &lt; n</code></li>
	<li>All the values <code>Node.val</code> are <strong>unique</strong>.</li>
	<li><code>1 &lt;= nums.length &lt;= n</code></li>
	<li><code>0 &lt;= nums[i] &lt; n</code></li>
	<li>All the values of <code>nums</code> are <strong>unique</strong>.</li>
</ul>
</div>