<h2><a href="https://leetcode.com/problems/regions-cut-by-slashes/"><div id="big-omega-company-tags"><div id="big-omega-topbar"><div class="companyTagsContainer" style="overflow-x: scroll; flex-wrap: nowrap;"><div class="companyTagsContainer--tag">No companies found for this problem</div></div><div class="companyTagsContainer--chevron"><div><svg version="1.1" id="icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 32 32" fill="#4087F1" xml:space="preserve" style="width: 20px;"><polygon points="16,22 6,12 7.4,10.6 16,19.2 24.6,10.6 26,12 "></polygon><rect id="_x3C_Transparent_Rectangle_x3E_" class="st0" fill="none" width="32" height="32"></rect></svg></div></div></div></div>959. Regions Cut By Slashes</a></h2><h3>Medium</h3><hr><div><p>An <code>n x n</code> grid is composed of <code>1 x 1</code> squares where each <code>1 x 1</code> square consists of a <code>'/'</code>, <code>'\'</code>, or blank space <code>' '</code>. These characters divide the square into contiguous regions.</p>

<p>Given the grid <code>grid</code> represented as a string array, return <em>the number of regions</em>.</p>

<p>Note that backslash characters are escaped, so a <code>'\'</code> is represented as <code>'\\'</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/15/1.png" style="width: 200px; height: 200px;">
<pre><strong>Input:</strong> grid = [" /","/ "]
<strong>Output:</strong> 2
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/15/2.png" style="width: 200px; height: 198px;">
<pre><strong>Input:</strong> grid = [" /","  "]
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/15/4.png" style="width: 200px; height: 200px;">
<pre><strong>Input:</strong> grid = ["/\\","\\/"]
<strong>Output:</strong> 5
<strong>Explanation: </strong>Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == grid.length == grid[i].length</code></li>
	<li><code>1 &lt;= n &lt;= 30</code></li>
	<li><code>grid[i][j]</code> is either <code>'/'</code>, <code>'\'</code>, or <code>' '</code>.</li>
</ul>
</div>